package com.amazonaws.services.s3;

import com.amazonaws.services.s3.internal.FileDeletionEvent;

public interface OnFileDelete {
    void onFileDelete(FileDeletionEvent fileDeletionEvent);
}
