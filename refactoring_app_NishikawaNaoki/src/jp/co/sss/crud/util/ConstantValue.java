package jp.co.sss.crud.util;

public class ConstantValue {

	/** インスタンス化を禁止 */
	private ConstantValue() {
	}

	// ***** メニュー選択の設定値 *****

	/** 全件検索 */
	public static final int MENU_FIND_ALL = 1;

	/** 社員名検索 */
	public static final int MENU_FIND_BY_EMP_NAME = 2;

	/** 部署名検索 */
	public static final int MENU_FIND_BY_DEPT_ID = 3;

	/** 登録 */
	public static final int MENU_INSERT = 4;

	/** 更新 */
	public static final int MENU_UPDATE = 5;

	/** 削除 */
	public static final int MENU_DELETE = 6;

	/** 終了 */
	public static final int MENU_EXIT = 7;

}
