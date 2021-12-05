import json
import requests


def test_should_return_200_with_error_if_invalid_body():
    result = requests.post('https://gotiny.cc/api', data={'input': 'https://amazon.com/very-long-url'})
    assert result.status_code == 200
    assert result.text is not None
    assert result.json()['error']['message'] == 'No input provided'


def test_should_return_400_if_wrong_data_and_header():
    result = requests.post('https://gotiny.cc/api', data={'input': 'https://amazon.com/very-long-url'},
                           headers={'Content-Type': 'application/json'})
    assert result.status_code == 400


def test_should_return_200_and_have_proper_body_if_success():
    url = 'https://amazon.com/very-long-url'
    result = requests.post('https://gotiny.cc/api', json={'input': url})
    # zawsze zwraca jednoelementową listę
    json_result = result.json()[0]
    assert result.status_code == 200
    assert result.text is not None
    assert json_result['long'] == url
    # test czy nie jest puste, bo jest inne przy każdym requescie
    assert json_result['code'] is not None
    assert len(json_result['code']) != 0


def test_should_return_404_for_invalid_request_endpoint():
    result = requests.post('https://gotiny.cc/ai', json={})
    assert result.status_code == 404
