import json
import requests


def test_should_return_200_and_have_proper_body_if_success():
    expected = open("resources/tenders_success.json", "r").read()
    result = requests.get('https://tenders.guru/api/pl/tenders/510041')
    assert result.status_code == 200
    assert result.text is not None
    assert json.loads(expected) == result.json()


def test_should_return_500_for_invalid_id():
    result = requests.get('https://tenders.guru/api/pl/tenders/0')
    assert result.status_code == 500


def test_should_return_404_for_invalid_request_endpoint():
    result = requests.get('https://tenders.guru/api/pl/nders/0')
    assert result.status_code == 404


def test_should_return_200_and_have_few_proper_keys():
    result = requests.get('https://tenders.guru/api/pl/tenders/510041')
    assert result.status_code == 200
    assert result.text is not None
    expected = ['title', 'category', 'description', 'awarded_currency', 'purchaser', 'type', 'notices', 'id', 'date',
                'deadline_date', 'deadline_length_days', 'awarded', 'deadline_length_hours', 'sid', 'awarded_value',
                'awarded_value_eur']
    a = json.loads(result.text)
    for key, value in a.items():
        assert key in expected
