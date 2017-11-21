package org.bakara.web;

import java.util.ArrayList;
import java.util.List;

import org.bakara.dto.TeamPlayerDTO;
import org.bakara.service.TeamPlayerService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/admin/*")
@Log
public class TeamPlayerController{
	
	private WebDriver driver;
	
	private List<String> playerPage = new ArrayList<>();
	
	@Autowired
	private TeamPlayerService service;
	
	@GetMapping("/teamplayers")
	public void teamPlayers() throws Exception{
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
					TeamPlayerDTO dto = new TeamPlayerDTO(); 
					
					dto.setPlayerNum(Long.parseLong(player.findElement(By.cssSelector("td:nth-child(1)")).getText()));
					dto.setPlayerName(player.findElement(By.cssSelector("td:nth-child(2)")).getText());
					dto.setTeamName(player.findElement(By.cssSelector("td:nth-child(3)")).getText());
					dto.setPosition( player.findElement(By.cssSelector("td:nth-child(4)")).getText()); 
					dto.setBirthday( player.findElement(By.cssSelector("td:nth-child(5)")).getText());
					dto.setHnW( player.findElement(By.cssSelector("td:nth-child(6)")).getText());
					dto.setSchool( player.findElement(By.cssSelector("td:nth-child(7)")).getText());
					
					service.crawlTeamPlayer(dto);
				}
				
				

				List<WebElement> links = driver.findElement(By.className("tEx"))
						.findElements(By.cssSelector("tbody > tr > td > a"));

				for (WebElement link : links) {
					playerPage.add(link.getAttribute("href"));
				}
			}
		}

//		for (int i = 0; i < playerPage.size(); i++) {
//			if(!playerPage.get(i).contains("Futures")) {				
//				driver.get(playerPage.get(i));
//			}
//			Thread.sleep(1000);
//		}
	}

}
