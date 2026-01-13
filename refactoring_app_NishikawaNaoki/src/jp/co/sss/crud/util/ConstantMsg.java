package jp.co.sss.crud.util;

public class ConstantMsg {

	/** インスタンス化を禁止 */
	private ConstantMsg() {
	}

	// ***** メニュー表示のメッセージ *****

	public static final String STRING_SYSTEM_NAME = "=== 社員管理システム ===";

	public static final String STRING_ALL_SELECT = "1.全件表示";

	public static final String STRING_SELECT_BY_EMP_NAME = "2.社員名検索";

	public static final String STRING_SELECT_BY_DEPT_ID = "3.部署ID検索";

	public static final String STRING_INSERT = "4.新規登録";

	public static final String STRING_UPDATE = "5.更新";

	public static final String STRING_DELETE = "6.削除";

	public static final String STRING_EXIT = "7.終了";

	public static final String STRING_REQUEST_MENU_NUM = "メニュー番号を入力してください：";

	/** 入力用表示 */
	public static final String STRING_PROMPT_EMP_NAME = "社員名:";

	public static final String STRING_PROMPT_DEPT_ID = "部署ID(1:営業部、2:経理部、3:総務部)を入力してください:";

	public static final String STRING_PROMPT_SELECT_GENDER = "性別(0:その他, 1:男性, 2:女性, 9:回答なし):";

	public static final String STRING_PROMPT_BIRTHDAY = "生年月日(西暦年/月/日):";

	public static final String STRING_PROMPT_SELECT_DEPT_ID = "部署ID(1:営業部、2:経理部、3:総務部):";

	public static final String STRING_PROMPT_UPDATE_EMP_ID = "更新する社員の社員IDを入力してください：";

	public static final String STRING_PROMPT_DELETE_EMP_ID = "削除する社員の社員IDを入力してください：";

	/** 機能の動作完了メッセージ */

	public static final String STRING_UPDATE_FINISH = "社員情報を更新しました";

	public static final String STRING_EXIT_MSG = "システムを終了します。";

}
