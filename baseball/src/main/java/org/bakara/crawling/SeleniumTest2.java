package org.bakara.crawling;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest2 {
	
	//2017. 11. 22.
	//작성자: 정언락
	//목적: 셀레니움 테스트용 코드.
	
	public static WebDriver driver;

	public static List<String> playerPage = new ArrayList<>();

	public static void main(String[] args) throws Exception {
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

//			System.out.println("====================================");
//			System.out.println("팀: " + options.get(i).getText());
//			System.out.println("====================================");

			Thread.sleep(2000);

			Integer countPage = driver.findElement(By.className("paging")).findElements(By.tagName("a")).size();

			for (int j = 1; j < 2; j++) {// countPage - 1; j++) {
				List<WebElement> pages = driver.findElement(By.className("paging")).findElements(By.tagName("a"));
				pages.get(j).click();
//				System.out.println("====================================");
//				System.out.println("선수명단: " + pages.get(j).getText());
//				System.out.println("====================================");
				Thread.sleep(2000);

				List<WebElement> players = driver.findElement(By.className("tEx")).findElement(By.tagName("tbody"))
						.findElements(By.tagName("tr"));

				for (WebElement player : players) {
					String link = player.findElement(By.cssSelector("td > a")).getAttribute("href");
					if(!link.contains("Future")) {
//					System.out.print("등번호: " + player.findElement(By.cssSelector("td:nth-child(1)")).getText());
//						System.out.println("선수이름: " + player.findElement(By.cssSelector("td:nth-child(2)")).getText());
//						System.out.println(link);
						playerPage.add(link);
//					System.out.print(", 팀명: " + player.findElement(By.cssSelector("td:nth-child(3)")).getText());
//					System.out.print(", 포지션: " + player.findElement(By.cssSelector("td:nth-child(4)")).getText());
//					System.out.print(", 생년월일: " + player.findElement(By.cssSelector("td:nth-child(5)")).getText());
//					System.out.print(", 체격: " + player.findElement(By.cssSelector("td:nth-child(6)")).getText());
//					System.out.println("출신교: " + player.findElement(By.cssSelector("td:nth-child(7)")).getText());
					}
				}

//				List<WebElement> links = driver.findElement(By.className("tEx"))
//						.findElements(By.cssSelector("tbody > tr > td > a"));

//				for (WebElement link : links) {
//					// System.out.println("링크나옵니다: " + link.getAttribute("href"));
//					// if(!link.getAttribute("href").isEmpty()) {
//					playerPage.add(link.getAttribute("href"));
//					// }
//				}
			}
		}
		
		driver.get(playerPage.get(1));
		
		Thread.sleep(1000);
		
		System.out.println(driver.findElement(By.id("cphContents_cphContents_cphContents_playerProfile_imgProgile")).getAttribute("src"));

		List<WebElement> playerBasics = driver.findElement(By.className("player_basic")).findElements(By.tagName("span"));
		for(WebElement playerBasic : playerBasics) {
			System.out.println(playerBasic.getText());
		}
		
		
//		driver.get(playerPage.get(3));
//		
//		Thread.sleep(1000);

//		for (int i = 0; i < playerPage.size(); i++) {
//			if(!playerPage.get(i).contains("Futures")) {				
//				driver.get(playerPage.get(i));
//			}
//			Thread.sleep(1000);
//		}

		// for (WebElement option : options) {
		// if("두산".equals(option.getText())){
		// option.click();
		// Thread.sleep(1000);
		// }
		// }

	}

}
