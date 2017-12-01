package org.bakara.service;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.bakara.dto.BasicYearRecordDTO;
import org.bakara.dto.Criteria;
import org.bakara.dto.PlayerBasicDTO;
import org.bakara.dto.TeamPlayerDTO;
import org.bakara.dto.TeamRecordDTO;
import org.bakara.mapper.TeamPlayerMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

@Service
public class TeamPlayerServiceImpl implements TeamPlayerService {

	private WebDriver driver;

	private List<String> playerPage = new ArrayList<>();

	@Inject
	private TeamPlayerMapper mapper;

	@Override
	public void crawlPlayersInfo() throws Exception {

		mapper.resetTeamPlayers();  // ����  ���� �ߺ� ���� 
		mapper.resetBasicYearRecord();

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

		String baseUrl = "http://www.koreabaseball.com/";
		String playerSearch = "Player/Search.aspx";

		driver = new ChromeDriver();

		driver.get(baseUrl + playerSearch);

		int countOpt = driver.findElement(By.id("cphContents_cphContents_cphContents_ddlTeam"))
				.findElements(By.tagName("option")).size();
			//������ 
		
		for (int i = 1; i <countOpt; i++) {     			
	//	for (int i = 1; i < 2; i++) {// countOpt; i++) {     			
			List<WebElement> options = driver.findElement(By.id("cphContents_cphContents_cphContents_ddlTeam"))
					.findElements(By.tagName("option"));

			options.get(i).click();

			Thread.sleep(2000);

			Integer countPage = driver.findElement(By.className("paging")).findElements(By.tagName("a")).size();
				
			//������ ũ�Ѹ� 
			for (int j = 1; j < countPage - 1; j++) {
			//for (int j = 1; j < 2; j++) {// countPage - 1; j++) {
				List<WebElement> pages = driver.findElement(By.className("paging")).findElements(By.tagName("a"));
				pages.get(j).click();

				Thread.sleep(2000);

				List<WebElement> players = driver.findElement(By.className("tEx")).findElement(By.tagName("tbody"))
						.findElements(By.tagName("tr"));

				for (WebElement player : players) { //���� ��ũ 
					String link = player.findElement(By.cssSelector("td > a")).getAttribute("href");
					if (!link.contains("Future")) {

						/*TeamPlayerDTO dto = new TeamPlayerDTO();

						dto.setPlayerNum(
								Long.parseLong(player.findElement(By.cssSelector("td:nth-child(1)")).getText()));
						dto.setPlayerName(player.findElement(By.cssSelector("td:nth-child(2)")).getText());
						dto.setTeamName(player.findElement(By.cssSelector("td:nth-child(3)")).getText());
						dto.setPosition(player.findElement(By.cssSelector("td:nth-child(4)")).getText());
						dto.setBirthday(player.findElement(By.cssSelector("td:nth-child(5)")).getText());
						dto.setHnW(player.findElement(By.cssSelector("td:nth-child(6)")).getText());
						dto.setSchool(player.findElement(By.cssSelector("td:nth-child(7)")).getText());
						mapper.registerTeamPlayer(dto);*/
						playerPage.add(link);

						
					}
				}

			}
		}

		for (int i = 0; i < playerPage.size(); i++) {
			/*TeamPlayerDTO dto = new TeamPlayerDTO();*/
			PlayerBasicDTO PBdto = new PlayerBasicDTO();

			driver.get(playerPage.get(i));
			Thread.sleep(1000);

			/*dto.setPlayerImg(driver.findElement(By.id("cphContents_cphContents_cphContents_playerProfile_imgProgile"))
					.getAttribute("src"));*/
			PBdto.setPlayerImg(driver.findElement(By.id("cphContents_cphContents_cphContents_playerProfile_imgProgile"))
					.getAttribute("src"));
			List<WebElement> playerBasics = driver.findElement(By.className("player_basic"))
					.findElements(By.tagName("span"));
			String team = driver.findElement(By.className("team")).getText();
			
			//�׽�Ʈ 
			//System.out.println(team);
			
			

			// log.info(playerBasics.get(0).getText());
			// log.info("" + Long.parseLong(playerBasics.get(1).getText()));
			/*dto.setPlayerName(playerBasics.get(0).getText());*/
			PBdto.setPlayerName(playerBasics.get(0).getText());
			
//			/*dto.setPlayerNum(Long.parseLong(playerBasics.get(1).getText()));*/
			PBdto.setPlayerNum(playerBasics.get(1).getText());
			String test = playerBasics.get(1).getText();
			
			if(test.equals("")) {
				PBdto.setPlayerNum(("null"));
			}
			/*mapper.registerPlayerImg(dto);*/
		
			//�����⺻ ���� 
			
			PBdto.setBirthday(playerBasics.get(2).getText());
			PBdto.setPosition(playerBasics.get(3).getText());
			PBdto.setHnW(playerBasics.get(4).getText());
			PBdto.setSchool(playerBasics.get(5).getText());
			PBdto.setInitPayment(playerBasics.get(6).getText());
			PBdto.setSalary(playerBasics.get(7).getText());
			PBdto.setPickUpRank(playerBasics.get(8).getText());
			PBdto.setJoined(playerBasics.get(9).getText());
			PBdto.setTeamName(team);
			mapper.registerTeamPlayer(PBdto);
			
			
			
			BasicYearRecordDTO  BasicYearRecordDTO = new BasicYearRecordDTO () ;
			//2017(Ÿ�� ���� ) ������ 
			
			if (!PBdto.getPosition().contains("����")) {
				
				List<WebElement> BasicYearRecords3 = driver.findElement(By.className("mb10"))
						.findElement(By.tagName("tbody"))
						.findElements(By.tagName("tr"));
				
				for(WebElement BasicYearRecord3 :BasicYearRecords3) { 	 //dto �� �ִ� �ڵ� 
					

				    BasicYearRecordDTO.setPlayerName(playerBasics.get(0).getText());
					BasicYearRecordDTO.setPlayerNum(playerBasics.get(1).getText());
					BasicYearRecordDTO.setPosition("Ÿ��");
					
					
					BasicYearRecordDTO.setTeamname(BasicYearRecord3.findElement(By.cssSelector("td:nth-child(1)")).getText());
					
					if(BasicYearRecordDTO.getTeamname().contains( "����� �����ϴ�.")) {
						
						continue ;    // ����� ���� ������ ������ 
					}
					
					BasicYearRecordDTO.setAvg(BasicYearRecord3.findElement(By.cssSelector("td:nth-child(2)")).getText());
					BasicYearRecordDTO.setG(BasicYearRecord3.findElement(By.cssSelector("td:nth-child(3)")).getText());
					BasicYearRecordDTO.setPa(BasicYearRecord3.findElement(By.cssSelector("td:nth-child(4)")).getText());
					BasicYearRecordDTO.setAb(BasicYearRecord3.findElement(By.cssSelector("td:nth-child(5)")).getText());
					BasicYearRecordDTO.setR(BasicYearRecord3.findElement(By.cssSelector("td:nth-child(6)")).getText());
					BasicYearRecordDTO.setH(BasicYearRecord3.findElement(By.cssSelector("td:nth-child(7)")).getText());
					BasicYearRecordDTO.setTwob(BasicYearRecord3.findElement(By.cssSelector("td:nth-child(8)")).getText());
					BasicYearRecordDTO.setThreeb(BasicYearRecord3.findElement(By.cssSelector("td:nth-child(9)")).getText());
					BasicYearRecordDTO.setHr(BasicYearRecord3.findElement(By.cssSelector("td:nth-child(10)")).getText());
					BasicYearRecordDTO.setTb(BasicYearRecord3.findElement(By.cssSelector("td:nth-child(11)")).getText());
					BasicYearRecordDTO.setRbi(BasicYearRecord3.findElement(By.cssSelector("td:nth-child(12)")).getText());
					BasicYearRecordDTO.setSb(BasicYearRecord3.findElement(By.cssSelector("td:nth-child(13)")).getText());
					BasicYearRecordDTO.setCs(BasicYearRecord3.findElement(By.cssSelector("td:nth-child(14)")).getText());
					BasicYearRecordDTO.setSac(BasicYearRecord3.findElement(By.cssSelector("td:nth-child(15)")).getText());
					BasicYearRecordDTO.setSf(BasicYearRecord3.findElement(By.cssSelector("td:nth-child(16)")).getText());
		
					mapper.registerBasicYearRecordTaja(BasicYearRecordDTO);
					
				}
				
			}
			
			
			
			
			
		
			
			//2017 ���� (���� ���� ) ������ 
			if (PBdto.getPosition().contains("����")) {
				
				List<WebElement> BasicYearRecords1 = driver.findElement(By.className("tbl-type02-pd0"))
						.findElement(By.tagName("tbody"))
						.findElements(By.tagName("tr"));
//				
//				List<WebElement> BasicYearRecords2 = driver.findElement(By.className("tbl-type02"))
//						.findElement(By.className("tbl"))
//						.findElement(By.tagName("tbody"))
//						.findElements(By.tagName("tr"));
				for(WebElement BasicYearRecord1 :BasicYearRecords1) { 	 //dto �� �ִ� �ڵ� 
						
				
				
				
		
			    BasicYearRecordDTO.setPlayerName(playerBasics.get(0).getText());
				BasicYearRecordDTO.setPlayerNum(playerBasics.get(1).getText());
				BasicYearRecordDTO.setPosition("����");
				
			
				BasicYearRecordDTO.setTeamname(BasicYearRecord1.findElement(By.cssSelector("td:nth-child(1)")).getText());	
				
				if(BasicYearRecordDTO.getTeamname().contains( "����� �����ϴ�.")) {
					
					continue ;    // ����� ���� ������ ������ 
				}
				
				BasicYearRecordDTO.setEra(BasicYearRecord1.findElement(By.cssSelector("td:nth-child(2)")).getText());
				
				
				BasicYearRecordDTO.setG(BasicYearRecord1.findElement(By.cssSelector("td:nth-child(3)")).getText());
				BasicYearRecordDTO.setCg(BasicYearRecord1.findElement(By.cssSelector("td:nth-child(4)")).getText());
				BasicYearRecordDTO.setSho(BasicYearRecord1.findElement(By.cssSelector("td:nth-child(5)")).getText());
				BasicYearRecordDTO.setW(BasicYearRecord1.findElement(By.cssSelector("td:nth-child(6)")).getText());
				BasicYearRecordDTO.setL(BasicYearRecord1.findElement(By.cssSelector("td:nth-child(7)")).getText());
				BasicYearRecordDTO.setSv(BasicYearRecord1.findElement(By.cssSelector("td:nth-child(8)")).getText());
				BasicYearRecordDTO.setHld(BasicYearRecord1.findElement(By.cssSelector("td:nth-child(9)")).getText());
				BasicYearRecordDTO.setWpct(BasicYearRecord1.findElement(By.cssSelector("td:nth-child(10)")).getText());
				BasicYearRecordDTO.setTbf(BasicYearRecord1.findElement(By.cssSelector("td:nth-child(11)")).getText());
				BasicYearRecordDTO.setNp(BasicYearRecord1.findElement(By.cssSelector("td:nth-child(12)")).getText());
				BasicYearRecordDTO.setIp(BasicYearRecord1.findElement(By.cssSelector("td:nth-child(13)")).getText());
				BasicYearRecordDTO.setH(BasicYearRecord1.findElement(By.cssSelector("td:nth-child(14)")).getText());
				BasicYearRecordDTO.setTwob(BasicYearRecord1.findElement(By.cssSelector("td:nth-child(15)")).getText());
				BasicYearRecordDTO.setThreeb(BasicYearRecord1.findElement(By.cssSelector("td:nth-child(16)")).getText());
				BasicYearRecordDTO.setHr(BasicYearRecord1.findElement(By.cssSelector("td:nth-child(17)")).getText());
				
				//�׽�Ʈ
				System.out.println("���ȣ :"+  BasicYearRecordDTO.getPlayerNum());
				System.out.println("���� �̸� :"+  BasicYearRecordDTO.getPlayerName());
				System.out.println("���̸�:"+BasicYearRecordDTO.getTeamname());
				System.out.println("era :"+BasicYearRecord1.findElement(By.cssSelector("td:nth-child(2)")).getText());
				
				mapper.registerBasicYearRecordTusu(BasicYearRecordDTO);
				
				
				} //���� ���� ũ�Ѹ�  - ���̺� 1 ������ 
				
//				 ���̺� 2 ��°�� ������ �´� . ������ css �����ڰ� ��ġ�Ƿ�  ���� ��� �ϴٺ��� �˼� �����Ͱ��� �ð��� ������ ���� �����غ��� 
//				for(WebElement BasicYearRecord2 :BasicYearRecords2) { 	 //dto �� �ִ� �ڵ� 
//			
//					BasicYearRecordDTO.setSac(BasicYearRecord2.findElement(By.cssSelector("td:nth-child(1)")).getText());
//					 
//					System.out.println("sac:"+BasicYearRecordDTO.getSac());
//					
//					mapper.registerBasicYearRecord2(BasicYearRecordDTO);
//				}//���� ���� ũ�Ѹ�  - ���̺� 2������ 
//				
				
				//2017 ���� (���� ���� ) �� 
				
				
			
				
			}
			
			
		}
		

	}



	@Override
	public List<TeamPlayerDTO> selectTeamPlayer(String teamname) {
		return mapper.selectTeamPlayer(teamname); 
	}



	@Override
	public List<BasicYearRecordDTO> selectBasicYearRecord(String teamname) {
		return mapper.selectBasicYearRecord(teamname) ; 
	}



	@Override
	public List<BasicYearRecordDTO> listpage(int page) {
		if(page <= 0) {
			page = 1; 
		}
		page = (page-1) * 10 ; 
		
		return mapper.listpage(page) ; 
	}



	@Override
	public List<BasicYearRecordDTO> listCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.listCriteria(cri);
	}

}
