package org.bakara.crawling;

import java.util.ArrayList;
import java.util.List;

import org.bakara.dto.TeamPlayerDTO;
import org.bakara.service.TeamPlayerService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamPlayerCrawler {
	
	public WebDriver driver;

	public List<String> playerPage = new ArrayList<>();
	
	@Autowired
	public TeamPlayerService service;

	public void crawlTeamPlayer() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");  //������̹� ũ�ҵ���̹� ���� (����) 

		String baseUrl = "http://www.koreabaseball.com/";
		String playerSearch = "Player/Search.aspx";

		driver = new ChromeDriver(); // ������ ����̹��� ���ߴ� �۾� 

		driver.get(baseUrl + playerSearch); // ������ ���� 

		int countOpt = driver.findElement(By.id("cphContents_cphContents_cphContents_ddlTeam")) 
				.findElements(By.tagName("option")).size();

		for (int i = 1; i < 2; i++) {// countOpt; i++) {
			List<WebElement> options = driver.findElement(By.id("cphContents_cphContents_cphContents_ddlTeam"))
					.findElements(By.tagName("option"));

			options.get(i).click();

			System.out.println("====================================");
			System.out.println("��: " + options.get(i).getText());
			System.out.println("====================================");

			Thread.sleep(2000);

			Integer countPage = driver.findElement(By.className("paging")).findElements(By.tagName("a")).size();

			for (int j = 1; j < 2; j++) {// countPage - 1; j++) {
				List<WebElement> pages = driver.findElement(By.className("paging")).findElements(By.tagName("a"));
				pages.get(j).click();
				System.out.println("====================================");
				System.out.println("������: " + pages.get(j).getText());
				System.out.println("====================================");
				Thread.sleep(2000);

				List<WebElement> players = driver.findElement(By.className("tEx")).findElement(By.tagName("tbody"))
						.findElements(By.tagName("tr"));

				for (WebElement player : players) {
					TeamPlayerDTO dto = new TeamPlayerDTO(); 
					
					dto.setPlayerNum(Long.parseLong(player.findElement(By.cssSelector("td:nth-child(1)")).getText()));
					dto.setPlayerName(player.findElement(By.cssSelector("td:nth-child(2)")).getText());
					dto.setTeamname(player.findElement(By.cssSelector("td:nth-child(3)")).getText());
					dto.setPosition( player.findElement(By.cssSelector("td:nth-child(4)")).getText()); 
					dto.setBirthday( player.findElement(By.cssSelector("td:nth-child(5)")).getText());
					dto.setHnW( player.findElement(By.cssSelector("td:nth-child(6)")).getText());
					dto.setSchool( player.findElement(By.cssSelector("td:nth-child(7)")).getText());
					
					// ���� ó�� 
//					System.out.print("���ȣ: " + player.findElement(By.cssSelector("td:nth-child(1)")).getText());
//					System.out.print(", ������: " + player.findElement(By.cssSelector("td:nth-child(2)")).getText());
//					System.out.print(", ����: " + player.findElement(By.cssSelector("td:nth-child(3)")).getText());
//					System.out.print(", ������: " + player.findElement(By.cssSelector("td:nth-child(4)")).getText());
//					System.out.print(", �������: " + player.findElement(By.cssSelector("td:nth-child(5)")).getText());
//					System.out.print(", ü��: " + player.findElement(By.cssSelector("td:nth-child(6)")).getText());
//					System.out.println("��ű�: " + player.findElement(By.cssSelector("td:nth-child(7)")).getText());
				}
				
				
				// ��ũ ó�� 
				
				List<WebElement> links = driver.findElement(By.className("tEx"))
						.findElements(By.cssSelector("tbody > tr > td > a"));

				for (WebElement link : links) {
					// System.out.println("��ũ ���ɴϴ�: " + link.getAttribute("href"));
					// if(!link.getAttribute("href").isEmpty()) {
					playerPage.add(link.getAttribute("href"));
					// }
				}
			}
		}

//		for (int i = 0; i < playerPage.size(); i++) {
//			if(!playerPage.get(i).contains("Futures")) {				
//				driver.get(playerPage.get(i));
//			}
//			Thread.sleep(1000);
//		}

		// for (WebElement option : options) {
		// if("�λ�".equals(option.getText())){
		// option.click();
		// Thread.sleep(1000);
		// }
		// }

	}

}
