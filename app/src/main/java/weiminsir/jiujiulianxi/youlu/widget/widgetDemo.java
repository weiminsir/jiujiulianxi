package weiminsir.jiujiulianxi.youlu.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Weimin on 2016/3/14.
 */
public class widgetDemo extends AppWidgetProvider  {

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // TODO Auto-generated method stub
        System.out.println("appwidget--->onDeleted()");
        super.onDeleted(context, appWidgetIds);
    }

    @Override
    public void onDisabled(Context context) {
        // TODO Auto-generated method stub
        System.out.println("appwidget--->onDisabled()");
        super.onDisabled(context);
    }

    @Override
    public void onEnabled(Context context) {
        // TODO Auto-generated method stub
        System.out.println("appwidget--->onEnabled()");
        super.onEnabled(context);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        System.out.println("appwidget--->onReceive()");
        super.onReceive(context, intent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {
        // TODO Auto-generated method stub
        System.out.println("appwidget--->onUpdate()");
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }
}
