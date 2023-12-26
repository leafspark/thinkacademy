package com.tal.app.thinkacademy.business.study.study.materials.viewmodel;

import android.app.Application;
import com.tal.app.thinkacademy.business.study.study.entity.LearnMaterialsEntity;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.utils.AppGlobals;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/business/study/study/materials/viewmodel/MaterialsVM$requestMaterialList$1", "Lcom/tal/app/thinkacademy/lib/network/exception/IError;", "onError", "", "code", "", "msg", "", "onFail", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MaterialsVM.kt */
public final class MaterialsVM$requestMaterialList$1 implements IError {
    final /* synthetic */ MaterialsVM this$0;

    MaterialsVM$requestMaterialList$1(MaterialsVM materialsVM) {
        this.this$0 = materialsVM;
    }

    public void onFail(int i, String str) {
        String str2 = null;
        if (i != 0) {
            StateLiveData<LearnMaterialsEntity> materialListData = this.this$0.getMaterialListData();
            Application application = AppGlobals.INSTANCE.get();
            if (application != null) {
                str2 = application.getString(R.string.study_center_net_error);
            }
            materialListData.postFailure(i, str2);
            return;
        }
        StateLiveData<LearnMaterialsEntity> materialListData2 = this.this$0.getMaterialListData();
        Application application2 = AppGlobals.INSTANCE.get();
        if (application2 != null) {
            str2 = application2.getString(R.string.study_center_data_error);
        }
        materialListData2.postFailure(i, str2);
    }

    public void onError(int i, String str) {
        this.this$0.getMaterialListData().postError(i, str);
    }
}
