from django.urls import path
from . import views
urlpatterns = [
    path('actors/', views.all_users, name='all_actors'),
]