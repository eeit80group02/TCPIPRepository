package init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import global.GlobalService;

public class InsertMission {
	private static final String URL = GlobalService.URL;
	private static final String USERNAME = GlobalService.USERNAME;
	private static final String PASSWORD = GlobalService.PASSWORD;

	private static final String INSERT = "INSERT INTO Mission(name,host,endTime,missionPriority,missionPosition,missionStatus,mainMissionId,missionSetId) VALUES (?,?,?,?,?,?,?,?)";

	public static void start() {

		// 【將軍國小暑期服務】美人魚現身將軍嶼
		// 第一天
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "破冰時間");
			pstmt.setInt(2,8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 1);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 1); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "台灣好好吃");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "非常緊急");
			pstmt.setInt(5, 2);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 1); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "午餐時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 3);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 1); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "唱歌時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "非常緊急");
			pstmt.setInt(5, 4);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 1); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "繽紛一夏");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 5);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 1); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "回到溫暖的家");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "非常緊急");
			pstmt.setInt(5, 6);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 1); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "晚餐時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 7);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 1); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 第二天
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "早操時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 1);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 2); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "科學小尖兵");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "非常緊急");
			pstmt.setInt(5, 2);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 2); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "午餐時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 3);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 2); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "唱歌時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "非常緊急");
			pstmt.setInt(5, 4);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 2); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "我的家人");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 5);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 2); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "回到溫暖的家");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "非常緊急");
			pstmt.setInt(5, 6);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 2); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "淨灘");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 7);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 2); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "晚餐時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 8);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 2); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 第三天
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "早操時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 1);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 3); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "信任遊戲");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "非常緊急");
			pstmt.setInt(5, 2);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 3); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "午餐時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 3);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 3); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "唱歌時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "非常緊急");
			pstmt.setInt(5, 4);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 3); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "放風箏");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 5);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 3); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "回到溫暖的家");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "非常緊急");
			pstmt.setInt(5, 6);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 3); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "晚餐時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 7);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 3); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 第四天
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "早操時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 1);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 4); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "美人魚的信物—搜索任務");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "非常緊急");
			pstmt.setInt(5, 2);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 4); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "隊輔時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 3);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 4); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "午餐時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "非常緊急");
			pstmt.setInt(5, 4);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 4); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "唱歌時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 5);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 4); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "美人魚的信物—大地遊戲");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "非常緊急");
			pstmt.setInt(5, 6);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 4); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "晚餐時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 7);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 4); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 第五天
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "早操時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 1);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 5); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "將軍廚房");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "非常緊急");
			pstmt.setInt(5, 2);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 5); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "午餐時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 3);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 5); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "唱歌時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "非常緊急");
			pstmt.setInt(5, 4);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 5); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "排練時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 5);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 5); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "回到溫暖的家");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "非常緊急");
			pstmt.setInt(5, 6);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 5); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "晚會時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 7);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 5); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 第六天
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "早操時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 1);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 6); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "小天使");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "非常緊急");
			pstmt.setInt(5, 2);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 6); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "午餐時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 3);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 6); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "烏龜卡片");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "非常緊急");
			pstmt.setInt(5, 4);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 6); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "分享時間");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 5);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 6); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "頒獎典禮");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "非常緊急");
			pstmt.setInt(5, 6);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 6); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "回到溫暖的家");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 7);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 6); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 偏鄉科學創意教學深耕計畫
		// 人事費
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "行政管銷");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 1);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 7); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "教材加工人事費");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 2);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 7); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "事務費");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 3);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 7); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "助教費用");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 4);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 7); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "郵電等耗材費用");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 5);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 7); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 活動費
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "伙食費");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 1);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 8); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "交通費");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 2);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 8); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "住宿費");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 3);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 8); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 教材費
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "學童教材費");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 1);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 9); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 教材費
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "教材繼送費");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 1);
			pstmt.setString(6, "進行中");
			pstmt.setNull(7, java.sql.Types.INTEGER);
			pstmt.setInt(8, 10); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 【將軍國小暑期服務】美人魚現身將軍嶼
		// 子任務
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "仙女棒");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 1);
			pstmt.setString(6, "進行中");
			pstmt.setInt(7, 9);
			pstmt.setInt(8, 2); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, "會下雪的聖誕樹");
			pstmt.setInt(2, 8);
			pstmt.setTimestamp(3, new Timestamp(GlobalService.convertStringToDate("2015-05-27").getTime()));
			pstmt.setString(4, "普通");
			pstmt.setInt(5, 2);
			pstmt.setString(6, "進行中");
			pstmt.setInt(7, 9);
			pstmt.setInt(8, 2); // MissionSetId 待填

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("任務資料新增完成");
	}

	public static void main(String[] args) {
		InsertMission.start();
	}
}
