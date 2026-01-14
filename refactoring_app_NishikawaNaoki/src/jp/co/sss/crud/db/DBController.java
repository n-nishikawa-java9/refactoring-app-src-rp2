package jp.co.sss.crud.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jp.co.sss.crud.io.ConsoleWirter;
import jp.co.sss.crud.util.ConstantSQL;
import jp.co.sss.crud.util.ConstantValue;

/**
 * DB操作処理用のクラス
 *
 * @author System Shared
 */
public class DBController {

	/** インスタンス化を禁止 */
	private DBController() {
	}

	/**
	 * 全ての社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 */
	public static void findAll() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			//resultSetの結果Setがない場合はfalse
			if (!resultSet.isBeforeFirst()) {
				ConsoleWirter.showNotFaound();
				return;
			}

			// レコードを出力
			ConsoleWirter.showListHeader();
			while (resultSet.next()) {
				System.out.print(resultSet.getString("emp_id"));
				ConsoleWirter.showBlank();
				System.out.print(resultSet.getString("emp_name"));
				ConsoleWirter.showBlank();

				int gender = Integer.parseInt(resultSet.getString("gender"));
				if (gender == ConstantValue.GENDER_NO_ANSER) {
					ConsoleWirter.showGenderNoAns();
					ConsoleWirter.showBlank();

				} else if (gender == ConstantValue.GENDER_MALE) {
					ConsoleWirter.showGenderMale();
					ConsoleWirter.showBlank();

				} else if (gender == ConstantValue.GENDER_FEMALE) {
					ConsoleWirter.showGenderFemale();
					ConsoleWirter.showBlank();

				} else if (gender == ConstantValue.GENDER_NON_BINALY) {
					ConsoleWirter.showGenderNonBinaly();
					ConsoleWirter.showBlank();

				}

				System.out.print(resultSet.getString("birthday"));
				ConsoleWirter.showBlank();
				System.out.println(resultSet.getString("dept_name"));
			}

			System.out.println("");
		} finally {
			// ResultSetをクローズ
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員名に該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static void findByEmpName() throws ClassNotFoundException, SQLException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 検索ワード
		String searchWord = br.readLine();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setString(1, "%" + searchWord + "%");

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();
			if (!resultSet.isBeforeFirst()) {
				ConsoleWirter.showNotFaound();
				return;
			}

			ConsoleWirter.showListHeader();
			while (resultSet.next()) {
				System.out.print(resultSet.getString("emp_id"));
				ConsoleWirter.showBlank();

				System.out.print(resultSet.getString("emp_name"));
				ConsoleWirter.showBlank();

				String genderString = resultSet.getString("gender");
				int gender = Integer.parseInt(genderString);
				if (gender == ConstantValue.GENDER_NO_ANSER) {
					ConsoleWirter.showGenderNoAns();

				} else if (gender == ConstantValue.GENDER_MALE) {
					ConsoleWirter.showGenderMale();

				} else if (gender == ConstantValue.GENDER_FEMALE) {
					ConsoleWirter.showGenderFemale();

				} else if (gender == ConstantValue.GENDER_NON_BINALY) {
					ConsoleWirter.showGenderNonBinaly();

				}

				ConsoleWirter.showBlank();
				System.out.print(resultSet.getString("birthday"));
				ConsoleWirter.showBlank();

				System.out.println(resultSet.getString("dept_name"));
			}

			System.out.println("");

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 部署IDに該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static void findByDeptId(String deptId) throws ClassNotFoundException, SQLException, IOException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(1, Integer.parseInt(deptId));

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			if (!resultSet.isBeforeFirst()) {
				ConsoleWirter.showNotFaound();
				return;
			}

			ConsoleWirter.showListHeader();
			while (resultSet.next()) {
				System.out.print(resultSet.getString("emp_id"));
				ConsoleWirter.showBlank();

				System.out.print(resultSet.getString("emp_name"));
				ConsoleWirter.showBlank();

				String genderString = resultSet.getString("gender");
				int gender = Integer.parseInt(genderString);
				if (gender == ConstantValue.GENDER_NO_ANSER) {
					ConsoleWirter.showGenderNoAns();

				} else if (gender == ConstantValue.GENDER_MALE) {
					ConsoleWirter.showGenderMale();

				} else if (gender == ConstantValue.GENDER_FEMALE) {
					ConsoleWirter.showGenderFemale();

				} else if (gender == ConstantValue.GENDER_NON_BINALY) {
					ConsoleWirter.showGenderNonBinaly();

				}

				ConsoleWirter.showBlank();
				System.out.print(resultSet.getString("birthday"));
				ConsoleWirter.showBlank();

				String deptIdString = resultSet.getString("dept_id");
				int deptIdForSearch = Integer.parseInt(deptIdString);
				if (deptIdForSearch == ConstantValue.SALE_DEPT) {
					ConsoleWirter.showDeptSale();
					ConsoleWirter.showNewLine();
				} else if (deptIdForSearch == ConstantValue.ACCOUNTING_DEPT) {
					ConsoleWirter.showDeptAccounting();
					ConsoleWirter.showNewLine();
				} else if (gender == ConstantValue.GENERAL_AFFAIRS_DEPT) {
					ConsoleWirter.showDeptGeneralAffairs();
					ConsoleWirter.showNewLine();
				}
			}

			System.out.println("");
		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件登録
	 * 
	 * @param empName 社員名
	 * @param gender 性別
	 * @param birthday 生年月日
	 * @param deptId 部署ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static void insert(String empName, String gender, String birthday, String deptId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(1, empName);
			preparedStatement.setInt(2, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(4, Integer.parseInt(deptId));

			// SQL文を実行
			preparedStatement.executeUpdate();

			// 登録完了メッセージを出力
			ConsoleWirter.showInsertFin();
		} finally {
			DBManager.close(preparedStatement);
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件更新
	 * 
	 * @param empId 社員ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static void update(String empId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			ConsoleWirter.showPromptEmpName();
			String emp_name = br.readLine();
			// 性別を入力
			ConsoleWirter.showPromptGender();
			String gender = br.readLine();
			// 誕生日を入力
			ConsoleWirter.showPromptBirthday();
			String birthday = br.readLine();

			// 部署IDを入力
			ConsoleWirter.showPromptDeptId();
			String deptId = br.readLine();

			// 入力値をバインド
			preparedStatement.setString(1, emp_name);
			preparedStatement.setInt(2, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(4, Integer.parseInt(deptId));
			preparedStatement.setInt(5, Integer.parseInt(empId));

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

		} finally {
			// クローズ処理
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件削除
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static void delete() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// データベースに接続
			connection = DBManager.getConnection();
			String empId = br.readLine();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 社員IDをバインド
			preparedStatement.setInt(1, Integer.parseInt(empId));

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

			ConsoleWirter.showDeleteFin();

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			// Statementをクローズ
			try {
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// DBとの接続を切断
		}
	}
}
