package weiminsir.jiujiulianxi.youlu.presenter;
import java.util.List;

import weiminsir.jiujiulianxi.youlu.entity.Calllog;
import weiminsir.jiujiulianxi.youlu.module.CalllogModel;
import weiminsir.jiujiulianxi.youlu.module.ICalllogModel;
import weiminsir.jiujiulianxi.youlu.view.IDialView;

public class DialPresenter implements IDialPresenter{
	private ICalllogModel model;
	private IDialView view;
	
	public DialPresenter(IDialView view) {
		this.view = view;
		this.model = new CalllogModel();
	}
	
	@Override
	public void loadAllCalllogs() {
		List<Calllog> logs = model.findAllCallogs();

		view.setCalllogList(logs);

		view.showList();
	}
	
}
