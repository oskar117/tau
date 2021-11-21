from time import sleep

from selenium.webdriver import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait

from BaseTest import BaseTest
from drivers.Driver import Driver


class MetallumScenario1(BaseTest):

    def __init__(self, driver_value: Driver, logger):
        super().__init__(driver_value, logger)

    def run(self):
        self.logger.info('Przechodzę na stronę metal-archives')
        self.driver.get('https://www.metal-archives.com/')
        self.logger.info('szukam zespołu')
        temp = self.driver.find_element_by_id('searchQueryBox')
        temp.send_keys('Metallica')
        temp.send_keys(Keys.RETURN)
        self.logger.info('Sprawdzam datę')
        temp = WebDriverWait(self.driver, 5).until(
            expected_conditions.presence_of_element_located(
                (By.XPATH, '//*[@id="band_stats"]/dl[1]/dd[4]'))
        )
        assert temp.text == '1981'

        self.logger.info('Passed!')


class MetallumScenario2(BaseTest):

    def __init__(self, driver_value: Driver, logger):
        super().__init__(driver_value, logger)

    def run(self):
        self.logger.info('Przechodzę na stronę metal-archives')
        self.driver.get('https://www.metal-archives.com/')
        self.logger.info('wchodzę w zakładkę rules')
        temp = self.driver.find_element_by_xpath('//*[@id="top_menu_box"]/ul[1]/li[2]/a')
        temp.click()
        sleep(1)
        self.logger.info('klikam na valid albums only')
        temp = self.driver.find_element_by_xpath('/html/body/div/div[3]/div/div/ul/li[2]/a')
        temp.click()
        self.logger.info('klikam na other versions of valid albums')
        temp = self.driver.find_element_by_xpath('//*[@id="ui-accordion-2-header-4"]/a')
        temp.click()
        self.logger.info('Sprawdzam zawartość drugiego paragrafu')
        temp = self.driver.find_element_by_xpath('/html/body/div/div[3]/div/div/div[2]/div/div[5]/p[2]')
        sleep(1)
        assert temp.text == 'On occasion, there will be an "other version" of a valid album that may be ' \
                            'listed as its own entry within the band\'s discography. For the most part,' \
                            ' these versions differ significantly from the original version or, more commonly,' \
                            ' were reissued with another title or under another band name. Although these albums may ' \
                            'warrant their own inclusion in the discography, they are all connected as ' \
                            '"other versions" of the original album that they are based off of.'
        self.logger.info('Passed!')
