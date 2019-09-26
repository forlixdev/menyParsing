package testJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class TestConnectionMySql {

	public static void main(String[] args) {
		final int FETCH_SINGLE_ROW = Integer.MIN_VALUE;
		String server = "sig-q-mysql05";
		String port = "3306";

		String encDbName = "signicat_encrypted";
		String encUser = "s_encrypted";
		String encPwd = "rackabajsare";
		String encConnectionString = "jdbc:mysql://" + server + ":" + port + "/" + encDbName;

		String comDbName = "signicat_common";
		String comUser = "signicat03";
		String comPwd = "oomariltistr";
		String comConnectionString = "jdbc:mysql://" + server + ":" + port + "/" + comDbName;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println("===============  " + timestamp);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			System.exit(1);
		}
		long startTime = System.currentTimeMillis();
		ResultSet result;
		int cnt = 0;
		try (Connection connEnc = DriverManager.getConnection(encConnectionString, encUser, encPwd)) {
			String encryptedSql = "SELECT id, creation_time FROM encrypted_entry WHERE marked_for_deletion_time IS NULL";
			Statement statement = connEnc.createStatement();
			statement.setFetchSize(1000);
			result = statement.executeQuery(encryptedSql);
			while (result.next()) {
				String archiveId = result.getString(1);
				try (Connection connCom = DriverManager.getConnection(comConnectionString, comUser, comPwd)) {
					final String docSql = "SELECT archive_id FROM document_archive_document where encrypted_entry_id = ?";
					PreparedStatement docPreparedStatement = connCom.prepareStatement(docSql);
					docPreparedStatement.setString(1, archiveId);
					ResultSet rsCom = docPreparedStatement.executeQuery();
					cnt++;
					long timeelapsed = (System.currentTimeMillis() - startTime);
					while (rsCom.next()) {
						System.out.println(rsCom.getString(1)+" --> Time elapsed: "+timeelapsed/1000+"s --> number of file processed: "+cnt+" --> rate (ms/file): "+timeelapsed/cnt);
					}
				} catch (SQLException e) {
					System.out.println(e);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}
}
