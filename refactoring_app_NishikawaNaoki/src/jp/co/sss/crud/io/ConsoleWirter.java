package jp.co.sss.crud.io;

import jp.co.sss.crud.util.ConstantMsg;

/**
 * メニューのコンソール出力用クラス
 * コンソールへの画面出力を集約する。入力の取得、バリデーションは行わない。
 * 
 */
public class ConsoleWirter {
	/**
	 * メニュー表示メソッド
	 */
	public static void showMenu() {
		System.out.println(ConstantMsg.STRING_SYSTEM_NAME);
		System.out.println(ConstantMsg.STRING_ALL_SELECT);
		System.out.println(ConstantMsg.STRING_SELECT_BY_EMP_NAME);
		System.out.println(ConstantMsg.STRING_SELECT_BY_DEPT_ID);
		System.out.println(ConstantMsg.STRING_INSERT);
		System.out.println(ConstantMsg.STRING_UPDATE);
		System.out.println(ConstantMsg.STRING_DELETE);
		System.out.println(ConstantMsg.STRING_EXIT);
		System.out.print(ConstantMsg.STRING_REQUEST_MENU_NUM);
	}

	/**
	 * 社員名入力表示用メソッド
	 */
	public static void showPromptEmpName() {
		System.out.print(ConstantMsg.STRING_PROMPT_EMP_NAME);
	}

	/**
	 * 部署ID入力表示用メソッド
	 */
	public static void showPromptDeptId() {
		System.out.print(ConstantMsg.STRING_PROMPT_DEPT_ID);
	}

	/**
	 * 性別入力表示用メソッド
	 */
	public static void showPromptGender() {
		System.out.print(ConstantMsg.STRING_PROMPT_GENDER);
	}

	/**
	 * 生年月日入力表示用メソッド
	 */
	public static void showPromptBirthday() {
		System.out.print(ConstantMsg.STRING_PROMPT_BIRTHDAY);
	}

	/**
	 * 更新用社員ID入力表示メソッド
	 */
	public static void showEmpIdUpdate() {
		System.out.print(ConstantMsg.STRING_PROMPT_UPDATE_EMP_ID);
	}

	/**
	 * 更新完了表示メソッド
	 */
	public static void showUpdateFin() {
		System.out.println(ConstantMsg.STRING_UPDATE_FINISH);
	}

	/**
	 * 登録用社員ID入力メソッド
	 */
	public static void showEmpIdDelete() {
		System.out.print(ConstantMsg.STRING_PROMPT_DELETE_EMP_ID);
	}

	/**
	 * システム終了表示メソッド
	 */
	public static void showSystemExit() {
		System.out.println(ConstantMsg.STRING_EXIT_MSG);
	}

}
