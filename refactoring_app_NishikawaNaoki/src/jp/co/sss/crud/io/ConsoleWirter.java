package jp.co.sss.crud.io;

import jp.co.sss.crud.util.ConstantMsg;

/**
 * メニューのコンソール出力用クラス
 * コンソールへの画面出力を集約する。入力の取得、バリデーションは行わない。
 * 表示内容はConstantMsg.javaに集約している
 */
public class ConsoleWirter {
	/**
	 * メニュー表示
	 */
	public static void showMenu() {
		System.out.println(ConstantMsg.STRING_SYSTEM_NAME);
		System.out.println(ConstantMsg.STRING_FIND_ALL);
		System.out.println(ConstantMsg.STRING_FIND_BY_EMP_NAME);
		System.out.println(ConstantMsg.STRING_FIND_BY_DEPT_ID);
		System.out.println(ConstantMsg.STRING_INSERT);
		System.out.println(ConstantMsg.STRING_UPDATE);
		System.out.println(ConstantMsg.STRING_DELETE);
		System.out.println(ConstantMsg.STRING_EXIT);
		System.out.print(ConstantMsg.STRING_REQUEST_MENU_NUM);
	}

	/**
	 * 社員名入力表示用
	 */
	public static void showPromptEmpName() {
		System.out.print(ConstantMsg.STRING_PROMPT_EMP_NAME);
	}

	/**
	 * 部署ID入力表示用
	 */
	public static void showPromptDeptId() {
		System.out.print(ConstantMsg.STRING_PROMPT_DEPT_ID);
	}

	/**
	 * 性別入力表示用
	 */
	public static void showPromptGender() {
		System.out.print(ConstantMsg.STRING_PROMPT_GENDER);
	}

	/**
	 * 生年月日入力表示
	 */
	public static void showPromptBirthday() {
		System.out.print(ConstantMsg.STRING_PROMPT_BIRTHDAY);
	}

	/**
	 * 登録完了表示
	 */
	public static void showInsertFin() {
		System.out.println(ConstantMsg.STRING_INSERT_FINISH);
	}

	/**
	 * 更新用社員ID入力表示
	 */
	public static void showEmpIdUpdate() {
		System.out.print(ConstantMsg.STRING_PROMPT_UPDATE_EMP_ID);
	}

	/**
	 * 更新完了表示
	 */
	public static void showUpdateFin() {
		System.out.println(ConstantMsg.STRING_UPDATE_FINISH);
	}

	/**
	 * 削除用社員ID入力
	 */
	public static void showEmpIdDelete() {
		System.out.print(ConstantMsg.STRING_PROMPT_DELETE_EMP_ID);
	}

	public static void showDeleteFin() {
		System.out.println(ConstantMsg.STRING_DELETE_FINISH);
	}

	/**
	 * システム終了表示
	 */
	public static void showSystemExit() {
		System.out.println(ConstantMsg.STRING_EXIT_MSG);
	}

	/**
	 * 未登録表示
	 */
	public static void showNotFaound() {
		System.out.println(ConstantMsg.STRING_NOT_FOUND);
	}

	/**
	 * リスト用ヘッダー表示
	 */
	public static void showListHeader() {
		System.out.println(ConstantMsg.STRING_LIST_HEADER);
	}

	/**
	 * 空白表示
	 */
	public static void showBlank() {
		System.out.print(ConstantMsg.STRING_BLANK);
	}

	public static void showNewLine() {
		System.out.print(System.lineSeparator());
	}

	// ***** 性別 *****

	public static void showGenderNoAns() {
		System.out.print(ConstantMsg.STRING_GENDER_NO_ANSER);
	}

	public static void showGenderMale() {
		System.out.print(ConstantMsg.STRING_GENDER_MALE);
	}

	public static void showGenderFemale() {
		System.out.print(ConstantMsg.STRING_GENDER_FEMALE);
	}

	public static void showGenderNonBinaly() {
		System.out.print(ConstantMsg.STRING_GENDER_NON_BINALY);
	}

	// ***** 部署 *****

	public static void showDeptSale() {
		System.out.print(ConstantMsg.STRING_SALE_DEPT);
	}

	public static void showDeptAccounting() {
		System.out.print(ConstantMsg.STRING_ACCOUNTING_DEPT);
	}

	public static void showDeptGeneralAffairs() {
		System.out.print(ConstantMsg.STRING_GENERAL_AFFAIRS_DEPT);
	}

}
