from django.urls import path

from mateo import views

urlpatterns = [
    path("mateo/", views.temp_here, name="temp_here"),
]