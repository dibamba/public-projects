from datetime import datetime
from typing import Any

import geocoder as geocoder
import requests
from django.http import HttpResponse

from django.shortcuts import render
from django.template import loader


# Create your views here.
def temp_here(request):
    location = geocoder.ip('me').latlng
    temp = get_temp(location)
    template = loader.get_template('index.html')
    context = {'temp': temp}
    return HttpResponse(template.render(context, request))


def get_temp(location) -> Any:
    endpoint = "https://api.open-meteo.com/v1/forecast"
    api_request = f"{endpoint}?latitude={location[0]}&longitude={location[1]}&hourly=temperature_2m"
    now = datetime.now()
    hour = now.hour
    meteo_data = requests.get(api_request).json()
    temp = meteo_data["hourly"]["temperature_2m"][hour]
    return temp