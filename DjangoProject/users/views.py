from django.contrib.auth.models import User
from django.http import HttpResponse
from django.shortcuts import render
from users.models import Actor



# Create your views here.
def all_users(request):
    all_actors = Actor.objects.all()
    print("actors fetched: ")
    print(all_actors)
    context = {'all_actors': all_actors}
    return render(request, "../templates/index.html", context)