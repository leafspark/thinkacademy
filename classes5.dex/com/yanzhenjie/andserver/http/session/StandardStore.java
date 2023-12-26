package com.yanzhenjie.andserver.http.session;

import com.yanzhenjie.andserver.util.Assert;
import com.yanzhenjie.andserver.util.IOUtils;
import com.yanzhenjie.andserver.util.StringUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StandardStore implements Store {
    private File mDirectory;

    public StandardStore(File file) {
        this.mDirectory = file;
    }

    public boolean replace(StandardSession standardSession) throws IOException {
        Assert.notNull(standardSession, "The session can not be null.");
        String id = standardSession.getId();
        if (!StringUtils.isEmpty(id)) {
            ObjectOutputStream objectOutputStream = null;
            try {
                if (!IOUtils.createFolder(this.mDirectory)) {
                    IOUtils.closeQuietly((Closeable) null);
                    return false;
                }
                File file = new File(this.mDirectory, id);
                if (!IOUtils.createNewFile(file)) {
                    IOUtils.closeQuietly((Closeable) null);
                    return false;
                }
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(file));
                try {
                    standardSession.writeObject(objectOutputStream2);
                    IOUtils.closeQuietly(objectOutputStream2);
                    return true;
                } catch (IOException e) {
                    e = e;
                    objectOutputStream = objectOutputStream2;
                    try {
                        IOUtils.delFileOrFolder(new File(this.mDirectory, id));
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        IOUtils.closeQuietly(objectOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    objectOutputStream = objectOutputStream2;
                    IOUtils.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                IOUtils.delFileOrFolder(new File(this.mDirectory, id));
                throw e;
            }
        } else {
            throw new IllegalStateException("The session id can not be empty or null.");
        }
    }

    public StandardSession getSession(String str) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream;
        IOException e;
        if (!StringUtils.isEmpty(str)) {
            ObjectInputStream objectInputStream2 = null;
            try {
                File file = new File(this.mDirectory, str);
                if (file.exists()) {
                    if (!file.isDirectory()) {
                        objectInputStream = new ObjectInputStream(new FileInputStream(file));
                        try {
                            StandardSession standardSession = new StandardSession();
                            standardSession.readObject(objectInputStream);
                            IOUtils.closeQuietly(objectInputStream);
                            return standardSession;
                        } catch (IOException e2) {
                            e = e2;
                            try {
                                IOUtils.delFileOrFolder(new File(this.mDirectory, str));
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                objectInputStream2 = objectInputStream;
                                IOUtils.closeQuietly(objectInputStream2);
                                throw th;
                            }
                        }
                    }
                }
                IOUtils.closeQuietly((Closeable) null);
                return null;
            } catch (IOException e3) {
                objectInputStream = null;
                e = e3;
                IOUtils.delFileOrFolder(new File(this.mDirectory, str));
                throw e;
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly(objectInputStream2);
                throw th;
            }
        } else {
            throw new IllegalArgumentException("The id can not be empty or null.");
        }
    }

    public boolean remove(StandardSession standardSession) {
        if (!StringUtils.isEmpty(standardSession.getId())) {
            return IOUtils.delFileOrFolder(new File(this.mDirectory, standardSession.getId()));
        }
        throw new IllegalStateException("The session id can not be empty or null.");
    }
}
