package another;


import org.openqa.selenium.chrome.ChromeOptions;

public class YandexOptions {
    public static ChromeOptions getYandexOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Users/SibVa/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
        return options;
    }


}
