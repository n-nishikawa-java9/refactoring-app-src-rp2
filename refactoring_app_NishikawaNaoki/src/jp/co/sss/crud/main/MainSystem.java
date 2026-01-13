package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 * @author System Shared
 *
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int menuNo = 0;

		do {
			// メニューの表示
			System.out.println(ConstantMsg.STRING_SYSTEM_NAME);
			System.out.println(ConstantMsg.STRING_ALL_SELECT);
			System.out.println(ConstantMsg.STRING_SELECT_BY_EMP_NAME);
			System.out.println(ConstantMsg.STRING_SELECT_BY_DEPT_ID);
			System.out.println(ConstantMsg.STRING_INSERT);
			System.out.println(ConstantMsg.STRING_UPDATE);
			System.out.println(ConstantMsg.STRING_DELETE);
			System.out.println(ConstantMsg.STRING_EXIT);
			System.out.print(ConstantMsg.STRING_REQUEST_MENU_NUM);

			// メニュー番号の入力
			String menuNoStr = br.readLine();
			menuNo = Integer.parseInt(menuNoStr);

			// 機能の呼出
			switch (menuNo) {
			case 1:
				// 全件表示機能の呼出
				DBController.findAll();
				break;

			case 2:
				// 社員名検索
				System.out.print(ConstantMsg.STRING_PROMPT_EMP_NAME);

				// 検索機能の呼出
				DBController.findByEmpName();
				break;

			case 3:
				// 検索する部署IDを入力
				System.out.print(ConstantMsg.STRING_PROMPT_DEPT_ID);
				String deptIdForSearch = br.readLine();

				// 検索機能の呼出
				DBController.findByDeptId(deptIdForSearch);
				break;

			case 4:
				// 登録する値を入力
				System.out.print(ConstantMsg.STRING_PROMPT_EMP_NAME);
				String emp_name = br.readLine();
				System.out.print(ConstantMsg.STRING_PROMPT_SELECT_GENDER);
				String gender = br.readLine();
				System.out.print(ConstantMsg.STRING_PROMPT_BIRTHDAY);
				String birthday = br.readLine();
				System.out.print(ConstantMsg.STRING_PROMPT_SELECT_DEPT_ID);
				String deptIdForInsert = br.readLine();

				// 登録機能の呼出
				DBController.insert(emp_name, gender, birthday, deptIdForInsert);
				break;

			case 5:
				// 更新する社員IDを入力
				System.out.print(ConstantMsg.STRING_PROMPT_UPDATE_EMP_ID);

				// 更新する値を入力する
				String empId_1 = br.readLine();
				Integer.parseInt(empId_1);

				// 更新機能の呼出
				DBController.update(empId_1);
				System.out.println(ConstantMsg.STRING_UPDATE_FINISH);

				break;

			case 6:
				// 削除する社員IDを入力
				System.out.print(ConstantMsg.STRING_PROMPT_DELETE_EMP_ID);

				// 削除機能の呼出
				DBController.delete();
				break;

			}
		} while (menuNo != 7);
		System.out.println(ConstantMsg.STRING_EXIT_MSG);
	}
}
