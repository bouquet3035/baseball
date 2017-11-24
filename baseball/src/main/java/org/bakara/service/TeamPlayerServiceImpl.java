package org.bakara.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

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

		mapper.resetTeamPlayers();

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

		String baseUrl = "http://www.koreabaseball.com/";
		String playerSearch = "Player/Search.aspx";

		driver = new ChromeDriver();

		driver.get(baseUrl + playerSearch);

		int countOpt = driver.findElement(By.id("cphContents_cphContents_cphContents_ddlTeam"))
				.findElements(By.tagName("option")).size();

		for (int i = 1; i < 2; i++) {// countOpt; i++) {
			List<WebElement> options = driver.findElement(By.id("cphContents_cphContents_cphContents_ddlTeam"))
					.findElements(By.tagName("option"));

			options.get(i).click();

			Thread.sleep(2000);

			Integer countPage = driver.findElement(By.className("paging")).findElements(By.tagName("a")).size();

			for (int j = 1; j < 2; j++) {// countPage - 1; j++) {
				List<WebElement> pages = driver.findElement(By.className("paging")).findElements(By.tagName("a"));
				pages.get(j).click();

				Thread.sleep(2000);

				List<WebElement> players = driver.findElement(By.className("tEx")).findElement(By.tagName("tbody"))
						.findElements(By.tagName("tr"));

				for (WebElement player : players) {
					String link = player.findElement(By.cssSelector("td > a")).getAttribute("href");
					if (!link.contains("Future")) {

						TeamPlayerDTO dto = new TeamPlayerDTO();

						dto.setPlayerNum(
								Long.parseLong(player.findElement(By.cssSelector("td:nth-child(1)")).getText()));
						dto.setPlayerName(player.findElement(By.cssSelector("td:nth-child(2)")).getText());
						dto.setTeamName(player.findElement(By.cssSelector("td:nth-child(3)")).getText());
						dto.setPosition(player.findElement(By.cssSelector("td:nth-child(4)")).getText());
						dto.setBirthday(player.findElement(By.cssSelector("td:nth-child(5)")).getText());
						dto.setHnW(player.findElement(By.cssSelector("td:nth-child(6)")).getText());
						dto.setSchool(player.findElement(By.cssSelector("td:nth-child(7)")).getText());

						playerPage.add(link);

						mapper.registerTeamPlayer(dto);
					}
				}

			}
		}

		for (int i = 0; i < playerPage.size(); i++) {
			TeamPlayerDTO dto = new TeamPlayerDTO();
			PlayerBasicDTO PBdto = new PlayerBasicDTO();

			driver.get(playerPage.get(i));
			Thread.sleep(1000);

			dto.setPlayerImg(driver.findElement(By.id("cphContents_cphContents_cphContents_playerProfile_imgProgile"))
					.getAttribute("src"));
			PBdto.setPlayerImg(driver.findElement(By.id("cphContents_cphContents_cphContents_playerProfile_imgProgile"))
					.getAttribute("src"));
			List<WebElement> playerBasics = driver.findElement(By.className("player_basic"))
					.findElements(By.tagName("span"));

			// log.info(playerBasics.get(0).getText());
			// log.info("" + Long.parseLong(playerBasics.get(1).getText()));
			dto.setPlayerName(playerBasics.get(0).getText());
			PBdto.setPlayerName(playerBasics.get(0).getText());
			
			dto.setPlayerNum(Long.parseLong(playerBasics.get(1).getText()));
			PBdto.setPlayerNum(Long.parseLong(playerBasics.get(1).getText()));

			mapper.registerPlayerImg(dto);
			
			PBdto.setBirthday(playerBasics.get(2).getText());
			PBdto.setPosition(playerBasics.get(3).getText());
			PBdto.setHnW(playerBasics.get(4).getText());
			PBdto.setSchool(playerBasics.get(5).getText());
			PBdto.setInitPayment(playerBasics.get(6).getText());
			PBdto.setSalary(playerBasics.get(7).getText());
			PBdto.setPickUpRank(playerBasics.get(8).getText());
			PBdto.setJoined(playerBasics.get(9).getText());
			
			
		}

	}

	@Override
	public List<TeamPlayerDTO> selectTeamPlayer(String teamname) {
		return mapper.selectTeamPlayer(teamname); 
	}

}
