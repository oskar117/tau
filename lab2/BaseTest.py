import logging

from selenium import webdriver

from drivers.Driver import Driver


class BaseTest:

    def __init__(self, driver_value: Driver, logger):
        self.driver_value = driver_value
        self.logger = logger

    def test(self):
        if self.driver_value == Driver.CHROME:
            self.driver = webdriver.Chrome(executable_path='drivers/chromedriver.exe')
        else:
            self.driver = webdriver.Edge(executable_path='drivers/msedgedriver.exe')
        self.run()
        self.driver.close()
        self.driver.quit()

    def run(self):
        pass
