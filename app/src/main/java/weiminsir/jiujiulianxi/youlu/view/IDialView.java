package weiminsir.jiujiulianxi.youlu.view;
import java.util.List;
import weiminsir.jiujiulianxi.youlu.entity.Calllog;
public interface IDialView {
	/**
	 *
	 * @param logs
	 */
	void setCalllogList(List<Calllog> logs);
	
	/**
	 *
	 */
	void showList();
}
