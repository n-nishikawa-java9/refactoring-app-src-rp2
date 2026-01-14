package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;
import jp.co.sss.crud.io.ConsoleWirter;
import jp.co.sss.crud.util.ConstantValue;

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
			ConsoleWirter.showMenu();

			// メニュー番号の入力
			String menuNoStr = br.readLine();
			menuNo = Integer.parseInt(menuNoStr);

			// 機能の呼出
			switch (menuNo) {
			case ConstantValue.MENU_FIND_ALL:
				// 全件表示機能の呼出
				DBController.findAll();
				break;

			case ConstantValue.MENU_FIND_BY_EMP_NAME:
				// 社員名検索
				ConsoleWirter.showPromptEmpName();

				// 検索機能の呼出
				DBController.findByEmpName();
				break;

			case ConstantValue.MENU_FIND_BY_DEPT_ID:
				// 検索する部署IDを入力
				ConsoleWirter.showPromptDeptId();
				String deptId_search = br.readLine();

				// 検索機能の呼出
				DBController.findByDeptId(deptId_search);
				break;

			case ConstantValue.MENU_INSERT:
				// 登録する値を入力
				ConsoleWirter.showPromptEmpName();
				String emp_name_insert = br.readLine();
				ConsoleWirter.showPromptGender();
				String gender_insert = br.readLine();
				ConsoleWirter.showPromptBirthday();
				String birthday_insert = br.readLine();
				ConsoleWirter.showPromptDeptId();
				String deptId_insert = br.readLine();

				// 登録機能の呼出
				DBController.insert(emp_name_insert, gender_insert, birthday_insert, deptId_insert);
				break;

			case ConstantValue.MENU_UPDATE:
				// 更新する社員IDを入力
				ConsoleWirter.showEmpIdUpdate();

				// 更新する値を入力する
				String empId_update = br.readLine();
				Integer.parseInt(empId_update);

				// 更新機能の呼出
				DBController.update(empId_update);
				ConsoleWirter.showUpdateFin();

				break;

			case ConstantValue.MENU_DELETE:
				// 削除する社員IDを入力
				ConsoleWirter.showEmpIdDelete();

				// 削除機能の呼出
				DBController.delete();
				break;

			}
		} while (menuNo != ConstantValue.MENU_EXIT);
		ConsoleWirter.showSystemExit();
	}
}
