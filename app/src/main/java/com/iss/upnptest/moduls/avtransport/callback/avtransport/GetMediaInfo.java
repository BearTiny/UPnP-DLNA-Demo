package com.iss.upnptest.moduls.avtransport.callback.avtransport;

import java.util.Map;
import org.fourthline.cling.model.action.ActionInvocation;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.InvalidValueException;
import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;
import com.iss.upnptest.moduls.avtransport.entity.MediaInfo;
import com.iss.upnptest.upnp.UpnpActionCallback;
import com.iss.upnptest.utils.LogUtil;

/**
 * @author hubing
 * @version 1.0.0 2015-4-28
 */

public abstract class GetMediaInfo extends UpnpActionCallback {

	private static String TAG = GetMediaInfo.class.getSimpleName();

	public GetMediaInfo(UnsignedIntegerFourBytes instanceId, Service service) {
		super(new ActionInvocation(service.getAction("GetMediaInfo")));
		try {
			setInput("InstanceID", instanceId);
		} catch (InvalidValueException e) {
			LogUtil.e(TAG, e);
		}
	}

	@Override
	public void received(ActionInvocation invocation, Map<String, Object> result) {
		MediaInfo mediaInfo = new MediaInfo(result);
		onSuccess(mediaInfo);
	}

	public abstract void onSuccess(MediaInfo mediaInfo);

}
