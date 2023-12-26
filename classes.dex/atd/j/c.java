package atd.j;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Build;
import atd.s0.a;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends b {
    public String a() {
        return a.a(-74645195516480L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public JSONArray c(Context context) throws atd.i.c {
        Set<BluetoothDevice> bondedDevices;
        JSONArray jSONArray = new JSONArray();
        BluetoothAdapter d = d(context);
        if (!(d == null || (bondedDevices = d.getBondedDevices()) == null)) {
            for (BluetoothDevice a : bondedDevices) {
                jSONArray.put(a(a));
            }
        }
        return jSONArray;
    }

    private JSONObject a(BluetoothDevice bluetoothDevice) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(a.a(-74658080418368L), bluetoothDevice.getName());
            jSONObject.put(a.a(-74670965320256L), bluetoothDevice.getAddress());
            if (Build.VERSION.SDK_INT >= 18) {
                jSONObject.put(a.a(-74705325058624L), bluetoothDevice.getType());
            }
            jSONObject.put(a.a(-74718209960512L), bluetoothDevice.getBondState());
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(a.a(-74503461595712L), e);
        }
    }
}
