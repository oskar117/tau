from time import sleep

from selenium.webdriver import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait

from BaseTest import BaseTest
from drivers.Driver import Driver


class ZalandoScenario1(BaseTest):

    def __init__(self, driver_value: Driver, logger):
        super().__init__(driver_value, logger)

    def run(self):
        self.logger.info('Przechodzę na stronę Zalando')
        self.driver.get('https://www.zalando.pl/')
        sleep(2)
        self.logger.info('Zamykam komunikat o ciasteczkach')
        temp = self.driver.find_element_by_xpath('//*[@id="uc-btn-accept-banner"]')
        temp.click()
        self.logger.info('Otwieram menu')
        temp = self.driver.find_element_by_xpath('//*[@id="z-navicat-header-root"]/header/div[2]/div/div/div/div[1]/div/div/div/div[2]/div[1]/a')
        temp.click()
        self.logger.info('Klikam pomoc i kontakt')
        temp = self.driver.find_element_by_xpath('/html/body/div[6]/div/div[2]/div/div/div[1]/div/ul/li[1]/a')
        temp.click()
        self.logger.info('Wypeniam formularz')
        temp = self.driver.find_element_by_xpath('/html/body/div[4]/div[5]/div/div/div/div/div/div/div[2]/div/div[1]/form/div/div/div[1]/div/div/input')
        temp.send_keys('test@wp.pl')
        temp = self.driver.find_element_by_xpath('/html/body/div[4]/div[5]/div/div/div/div/div/div/div[2]/div/div[1]/form/div/div/div[3]/div/div[2]/div/label')
        temp.click()
        self.logger.info('Klikam zapisz')
        temp = self.driver.find_element_by_xpath('/html/body/div[4]/div[5]/div/div/div/div/div/div/div[2]/div/div[1]/form/div/div/div[5]/button')
        temp.click()
        self.logger.info('Asercja komunikatu o potwierdzeniu')
        try:
            temp = WebDriverWait(self.driver, 30).until(
                expected_conditions.presence_of_element_located((By.XPATH, '/html/body/div[4]/div[5]/div/div/div/div/div/div/div[2]/div/div/div/div[2]/h4[1]'))
            )
        finally:
            assert temp.text == 'Już prawie!'

        self.logger.info('Passed!!!')


class ZalandoScenario2(BaseTest):

    def __init__(self, driver_value: Driver, logger):
        super().__init__(driver_value, logger)

    def run(self):
        self.logger.info('Przechodzę na stronę Zalando')
        self.driver.get('https://www.zalando.pl/')
        self.driver.maximize_window()
        sleep(2)
        self.logger.info('Zamykam komunikat o ciasteczkach')
        temp = self.driver.find_element_by_xpath('//*[@id="uc-btn-accept-banner"]')
        temp.click()
        self.logger.info('Wpisuje frazę w wyszukiwanie')
        temp = self.driver.find_element_by_xpath('//*[@id="z-navicat-header-root"]/header/div[2]/div/div/div/div[1]/div/div/div/div[2]/div[3]/form')
        temp.click()
        temp = self.driver.find_element_by_xpath('//*[@id="z-navicat-header-root"]/header/div[2]/div/div/div/div[1]/div/div/div/div[2]/div[3]/form/div/input')
        temp.send_keys('CLASSIC PLATFORM TROPICAL - Klapki')
        temp.send_keys(Keys.RETURN)
        self.logger.info('Klikam na pierwszy wynik')
        temp = self.driver.find_element_by_xpath('/html/body/div[4]/div/div/x-wrapper-re-1-1/div/div[7]/div/div[2]/div[2]/div[2]/div[1]/div[2]/article/a')
        temp.click()
        self.logger.info('Wybieram rozmiar')
        temp = self.driver.find_element_by_xpath('/html/body/div[4]/div/div[1]/div/div/div[2]/div[1]/x-wrapper-re-1-6/div/div[1]/div/div/button')
        temp.click()
        temp = self.driver.find_element_by_xpath('/html/body/div[6]/div/div[3]/div/form/div/div[1]/div/label/span/div/span[1]')
        temp.click()
        self.logger.info('dodaje do koszyka')
        temp = self.driver.find_element_by_xpath('/html/body/div[4]/div/div[1]/div/div/div[2]/div[1]/x-wrapper-re-1-6/div/div[2]/button')
        temp.click()
        self.logger.info('Sprawdzam czy jest w koszyku')
        temp = self.driver.find_element_by_xpath('/html/body/div[4]/div/x-wrapper-header/div/div/header/div[2]/div/div/div/div[1]/div/div/div/div[1]/div[3]/div/div[4]/div/div[2]/div[2]/div/div/div/div/div[1]/div/span/div[1]/a')

        assert temp.text == 'Crocs'

        self.logger.info('Passed!!!')

