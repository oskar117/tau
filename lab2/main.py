import logging

from drivers.Driver import Driver
from metallum import MetallumScenario1, MetallumScenario2
from zalando import ZalandoScenario1, ZalandoScenario2

logger = logging.getLogger("selenium")
logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)

tests = [
    ZalandoScenario1(Driver.CHROME, logger),
    ZalandoScenario2(Driver.CHROME, logger),
    MetallumScenario1(Driver.CHROME, logger),
    MetallumScenario2(Driver.CHROME, logger),
    ZalandoScenario1(Driver.EDGE, logger),
    ZalandoScenario2(Driver.EDGE, logger),
    MetallumScenario1(Driver.EDGE, logger),
    MetallumScenario2(Driver.EDGE, logger),
]

success = 0
for test in tests:
    try:
        test.test()
        success += 1
    except Exception:
        test.driver.close()
        test.driver.quit()

print('Success: ', success, 'fails', len(tests) - success)

