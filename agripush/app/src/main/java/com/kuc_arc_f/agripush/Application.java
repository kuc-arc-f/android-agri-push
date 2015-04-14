package com.kuc_arc_f.agripush;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.PushService;

public class Application extends android.app.Application {

  public Application() {
  }

  @Override
  public void onCreate() {
    super.onCreate();

	// Initialize the Parse SDK.
	Parse.initialize(this, "YOUR-APP-ID", "Your-Client-Key");

      PushService.setDefaultPushCallback(this, PushAct.class);
  }
}