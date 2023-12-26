package io.flutter.plugin.editing;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.InputMethodManager;
import com.tekartik.sqflite.Constant;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.yalantis.ucrop.view.CropImageView;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.editing.ListenableEditingState;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import kotlinx.coroutines.DebugKt;

public class InputConnectionAdaptor extends BaseInputConnection implements ListenableEditingState.EditingStateWatcher {
    private static final String TAG = "InputConnectionAdaptor";
    private int batchEditNestDepth;
    private FlutterTextUtils flutterTextUtils;
    private final KeyboardDelegate keyboardDelegate;
    private final int mClient;
    private CursorAnchorInfo.Builder mCursorAnchorInfoBuilder;
    private final ListenableEditingState mEditable;
    private final EditorInfo mEditorInfo;
    private ExtractedTextRequest mExtractRequest;
    private ExtractedText mExtractedText;
    private final View mFlutterView;
    private InputMethodManager mImm;
    private final Layout mLayout;
    private boolean mMonitorCursorUpdate;
    private final TextInputChannel textInputChannel;

    public interface KeyboardDelegate {
        boolean handleEvent(KeyEvent keyEvent);
    }

    public InputConnectionAdaptor(View view, int i, TextInputChannel textInputChannel2, KeyboardDelegate keyboardDelegate2, ListenableEditingState listenableEditingState, EditorInfo editorInfo, FlutterJNI flutterJNI) {
        super(view, true);
        this.mMonitorCursorUpdate = false;
        this.mExtractedText = new ExtractedText();
        this.batchEditNestDepth = 0;
        this.mFlutterView = view;
        this.mClient = i;
        this.textInputChannel = textInputChannel2;
        this.mEditable = listenableEditingState;
        listenableEditingState.addEditingStateListener(this);
        this.mEditorInfo = editorInfo;
        this.keyboardDelegate = keyboardDelegate2;
        this.flutterTextUtils = new FlutterTextUtils(flutterJNI);
        this.mLayout = new DynamicLayout(listenableEditingState, new TextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, false);
        this.mImm = (InputMethodManager) view.getContext().getSystemService("input_method");
    }

    public InputConnectionAdaptor(View view, int i, TextInputChannel textInputChannel2, KeyboardDelegate keyboardDelegate2, ListenableEditingState listenableEditingState, EditorInfo editorInfo) {
        this(view, i, textInputChannel2, keyboardDelegate2, listenableEditingState, editorInfo, new FlutterJNI());
    }

    private ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest) {
        CharSequence charSequence;
        this.mExtractedText.startOffset = 0;
        this.mExtractedText.partialStartOffset = -1;
        this.mExtractedText.partialEndOffset = -1;
        this.mExtractedText.selectionStart = this.mEditable.getSelectionStart();
        this.mExtractedText.selectionEnd = this.mEditable.getSelectionEnd();
        ExtractedText extractedText = this.mExtractedText;
        if (extractedTextRequest == null || (extractedTextRequest.flags & 1) == 0) {
            charSequence = this.mEditable.toString();
        } else {
            charSequence = this.mEditable;
        }
        extractedText.text = charSequence;
        return this.mExtractedText;
    }

    private CursorAnchorInfo getCursorAnchorInfo() {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        CursorAnchorInfo.Builder builder = this.mCursorAnchorInfoBuilder;
        if (builder == null) {
            this.mCursorAnchorInfoBuilder = new CursorAnchorInfo.Builder();
        } else {
            builder.reset();
        }
        this.mCursorAnchorInfoBuilder.setSelectionRange(this.mEditable.getSelectionStart(), this.mEditable.getSelectionEnd());
        int composingStart = this.mEditable.getComposingStart();
        int composingEnd = this.mEditable.getComposingEnd();
        if (composingStart < 0 || composingEnd <= composingStart) {
            this.mCursorAnchorInfoBuilder.setComposingText(-1, "");
        } else {
            this.mCursorAnchorInfoBuilder.setComposingText(composingStart, this.mEditable.toString().subSequence(composingStart, composingEnd));
        }
        return this.mCursorAnchorInfoBuilder.build();
    }

    public Editable getEditable() {
        return this.mEditable;
    }

    public boolean beginBatchEdit() {
        this.mEditable.beginBatchEdit();
        this.batchEditNestDepth++;
        return super.beginBatchEdit();
    }

    public boolean endBatchEdit() {
        boolean endBatchEdit = super.endBatchEdit();
        this.batchEditNestDepth--;
        this.mEditable.endBatchEdit();
        return endBatchEdit;
    }

    public boolean commitText(CharSequence charSequence, int i) {
        return super.commitText(charSequence, i);
    }

    public boolean deleteSurroundingText(int i, int i2) {
        if (this.mEditable.getSelectionStart() == -1) {
            return true;
        }
        return super.deleteSurroundingText(i, i2);
    }

    public boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        return super.deleteSurroundingTextInCodePoints(i, i2);
    }

    public boolean setComposingRegion(int i, int i2) {
        return super.setComposingRegion(i, i2);
    }

    public boolean setComposingText(CharSequence charSequence, int i) {
        boolean z;
        beginBatchEdit();
        if (charSequence.length() == 0) {
            z = super.commitText(charSequence, i);
        } else {
            z = super.setComposingText(charSequence, i);
        }
        endBatchEdit();
        return z;
    }

    public boolean finishComposingText() {
        return super.finishComposingText();
    }

    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        boolean z = true;
        boolean z2 = (i & 1) != 0;
        if (this.mExtractRequest != null) {
            z = false;
        }
        if (z2 == z) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled text monitoring ");
            sb.append(z2 ? DebugKt.DEBUG_PROPERTY_VALUE_ON : DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            Log.d(TAG, sb.toString());
        }
        this.mExtractRequest = z2 ? extractedTextRequest : null;
        return getExtractedText(extractedTextRequest);
    }

    public boolean requestCursorUpdates(int i) {
        boolean z = false;
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        if ((i & 1) != 0) {
            this.mImm.updateCursorAnchorInfo(this.mFlutterView, getCursorAnchorInfo());
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if (z != this.mMonitorCursorUpdate) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled cursor monitoring ");
            sb.append(z ? DebugKt.DEBUG_PROPERTY_VALUE_ON : DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            Log.d(TAG, sb.toString());
        }
        this.mMonitorCursorUpdate = z;
        return true;
    }

    public boolean clearMetaKeyStates(int i) {
        return super.clearMetaKeyStates(i);
    }

    public void closeConnection() {
        super.closeConnection();
        this.mEditable.removeEditingStateListener(this);
        while (this.batchEditNestDepth > 0) {
            endBatchEdit();
            this.batchEditNestDepth--;
        }
    }

    public boolean setSelection(int i, int i2) {
        beginBatchEdit();
        boolean selection = super.setSelection(i, i2);
        endBatchEdit();
        return selection;
    }

    private static int clampIndexToEditable(int i, Editable editable) {
        int max = Math.max(0, Math.min(editable.length(), i));
        if (max != i) {
            Log.d("flutter", "Text selection index was clamped (" + i + "->" + max + ") to remain in bounds. This may not be your fault, as some keyboards may select outside of bounds.");
        }
        return max;
    }

    public boolean sendKeyEvent(KeyEvent keyEvent) {
        return this.keyboardDelegate.handleEvent(keyEvent);
    }

    public boolean handleKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            if (keyEvent.getKeyCode() == 21) {
                return handleHorizontalMovement(true, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 22) {
                return handleHorizontalMovement(false, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 19) {
                return handleVerticalMovement(true, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 20) {
                return handleVerticalMovement(false, keyEvent.isShiftPressed());
            }
            if ((keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) && (131072 & this.mEditorInfo.inputType) == 0) {
                performEditorAction(this.mEditorInfo.imeOptions & 255);
                return true;
            }
            int selectionStart = Selection.getSelectionStart(this.mEditable);
            int selectionEnd = Selection.getSelectionEnd(this.mEditable);
            int unicodeChar = keyEvent.getUnicodeChar();
            if (selectionStart < 0 || selectionEnd < 0 || unicodeChar == 0) {
                return false;
            }
            int min = Math.min(selectionStart, selectionEnd);
            int max = Math.max(selectionStart, selectionEnd);
            beginBatchEdit();
            if (min != max) {
                this.mEditable.delete(min, max);
            }
            this.mEditable.insert(min, String.valueOf((char) unicodeChar));
            int i = min + 1;
            setSelection(i, i);
            endBatchEdit();
            return true;
        } else if (keyEvent.getAction() != 1 || (keyEvent.getKeyCode() != 59 && keyEvent.getKeyCode() != 60)) {
            return false;
        } else {
            int selectionEnd2 = Selection.getSelectionEnd(this.mEditable);
            setSelection(selectionEnd2, selectionEnd2);
            return true;
        }
    }

    private boolean handleHorizontalMovement(boolean z, boolean z2) {
        int i;
        int selectionStart = Selection.getSelectionStart(this.mEditable);
        int selectionEnd = Selection.getSelectionEnd(this.mEditable);
        boolean z3 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        if (z) {
            i = Math.max(this.flutterTextUtils.getOffsetBefore(this.mEditable, selectionEnd), 0);
        } else {
            i = Math.min(this.flutterTextUtils.getOffsetAfter(this.mEditable, selectionEnd), this.mEditable.length());
        }
        if (selectionStart == selectionEnd && !z2) {
            z3 = true;
        }
        if (z3) {
            setSelection(i, i);
        } else {
            setSelection(selectionStart, i);
        }
        return true;
    }

    private boolean handleVerticalMovement(boolean z, boolean z2) {
        int selectionStart = Selection.getSelectionStart(this.mEditable);
        int selectionEnd = Selection.getSelectionEnd(this.mEditable);
        boolean z3 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        if (selectionStart == selectionEnd && !z2) {
            z3 = true;
        }
        beginBatchEdit();
        if (z3) {
            if (z) {
                Selection.moveUp(this.mEditable, this.mLayout);
            } else {
                Selection.moveDown(this.mEditable, this.mLayout);
            }
            int selectionStart2 = Selection.getSelectionStart(this.mEditable);
            setSelection(selectionStart2, selectionStart2);
        } else {
            if (z) {
                Selection.extendUp(this.mEditable, this.mLayout);
            } else {
                Selection.extendDown(this.mEditable, this.mLayout);
            }
            setSelection(Selection.getSelectionStart(this.mEditable), Selection.getSelectionEnd(this.mEditable));
        }
        endBatchEdit();
        return true;
    }

    public boolean performContextMenuAction(int i) {
        beginBatchEdit();
        boolean doPerformContextMenuAction = doPerformContextMenuAction(i);
        endBatchEdit();
        return doPerformContextMenuAction;
    }

    private boolean doPerformContextMenuAction(int i) {
        if (i == 16908319) {
            setSelection(0, this.mEditable.length());
            return true;
        } else if (i == 16908320) {
            int selectionStart = Selection.getSelectionStart(this.mEditable);
            int selectionEnd = Selection.getSelectionEnd(this.mEditable);
            if (selectionStart != selectionEnd) {
                int min = Math.min(selectionStart, selectionEnd);
                int max = Math.max(selectionStart, selectionEnd);
                ((ClipboardManager) this.mFlutterView.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.mEditable.subSequence(min, max)));
                this.mEditable.delete(min, max);
                setSelection(min, min);
            }
            return true;
        } else if (i == 16908321) {
            int selectionStart2 = Selection.getSelectionStart(this.mEditable);
            int selectionEnd2 = Selection.getSelectionEnd(this.mEditable);
            if (selectionStart2 != selectionEnd2) {
                ((ClipboardManager) this.mFlutterView.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.mEditable.subSequence(Math.min(selectionStart2, selectionEnd2), Math.max(selectionStart2, selectionEnd2))));
            }
            return true;
        } else if (i != 16908322) {
            return false;
        } else {
            ClipData primaryClip = ((ClipboardManager) this.mFlutterView.getContext().getSystemService("clipboard")).getPrimaryClip();
            if (primaryClip != null) {
                CharSequence coerceToText = primaryClip.getItemAt(0).coerceToText(this.mFlutterView.getContext());
                int max2 = Math.max(0, Selection.getSelectionStart(this.mEditable));
                int max3 = Math.max(0, Selection.getSelectionEnd(this.mEditable));
                int min2 = Math.min(max2, max3);
                int max4 = Math.max(max2, max3);
                if (min2 != max4) {
                    this.mEditable.delete(min2, max4);
                }
                this.mEditable.insert(min2, coerceToText);
                int length = min2 + coerceToText.length();
                setSelection(length, length);
            }
            return true;
        }
    }

    public boolean performPrivateCommand(String str, Bundle bundle) {
        this.textInputChannel.performPrivateCommand(this.mClient, str, bundle);
        return true;
    }

    public boolean performEditorAction(int i) {
        if (i == 0) {
            this.textInputChannel.unspecifiedAction(this.mClient);
        } else if (i == 1) {
            this.textInputChannel.newline(this.mClient);
        } else if (i == 2) {
            this.textInputChannel.go(this.mClient);
        } else if (i == 3) {
            this.textInputChannel.search(this.mClient);
        } else if (i == 4) {
            this.textInputChannel.send(this.mClient);
        } else if (i == 5) {
            this.textInputChannel.next(this.mClient);
        } else if (i != 7) {
            this.textInputChannel.done(this.mClient);
        } else {
            this.textInputChannel.previous(this.mClient);
        }
        return true;
    }

    public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 25 && (i & 1) != 0) {
            try {
                inputContentInfo.requestPermission();
                if (inputContentInfo.getDescription().getMimeTypeCount() > 0) {
                    inputContentInfo.requestPermission();
                    Uri contentUri = inputContentInfo.getContentUri();
                    String mimeType = inputContentInfo.getDescription().getMimeType(0);
                    Context context = this.mFlutterView.getContext();
                    if (contentUri != null) {
                        try {
                            InputStream openInputStream = context.getContentResolver().openInputStream(contentUri);
                            if (openInputStream != null) {
                                byte[] readStreamFully = readStreamFully(openInputStream, WXMediaMessage.THUMB_LENGTH_LIMIT);
                                HashMap hashMap = new HashMap();
                                hashMap.put("mimeType", mimeType);
                                hashMap.put(Constant.PARAM_ERROR_DATA, readStreamFully);
                                hashMap.put("uri", contentUri.toString());
                                this.textInputChannel.commitContent(this.mClient, hashMap);
                                inputContentInfo.releasePermission();
                                return true;
                            }
                        } catch (FileNotFoundException unused) {
                            inputContentInfo.releasePermission();
                            return false;
                        }
                    }
                    inputContentInfo.releasePermission();
                }
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    private byte[] readStreamFully(InputStream inputStream, int i) {
        int i2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[i];
        while (true) {
            try {
                i2 = inputStream.read(bArr);
            } catch (IOException unused) {
                i2 = -1;
            }
            if (i2 == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    public void didChangeEditingState(boolean z, boolean z2, boolean z3) {
        this.mImm.updateSelection(this.mFlutterView, this.mEditable.getSelectionStart(), this.mEditable.getSelectionEnd(), this.mEditable.getComposingStart(), this.mEditable.getComposingEnd());
        if (Build.VERSION.SDK_INT >= 21) {
            ExtractedTextRequest extractedTextRequest = this.mExtractRequest;
            if (extractedTextRequest != null) {
                this.mImm.updateExtractedText(this.mFlutterView, extractedTextRequest.token, getExtractedText(this.mExtractRequest));
            }
            if (this.mMonitorCursorUpdate) {
                this.mImm.updateCursorAnchorInfo(this.mFlutterView, getCursorAnchorInfo());
            }
        }
    }
}
