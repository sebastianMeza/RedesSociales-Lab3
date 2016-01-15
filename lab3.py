from __future__ import absolute_import, print_function
from tweepy.streaming import StreamListener
from tweepy import OAuthHandler
from tweepy import Stream
import json


# Go to http://apps.twitter.com and create an app.
# The consumer key and secret will be generated for you after
consumer_key = 'UhxsygxiMzAf8FRVxf4zXYbCk'
consumer_secret = '71cvc8K6NYNf304UN3YfB4qCtR7R21sKkI9qZ0d3tXCOJlkue8'

# The access tokens can be found on your applications's Details
# page located at https://dev.twitter.com/apps (located
# under "Your access token")
access_token = '4784785401-ByrDEiU6vPKnyVDya8Ybh55PIdcAAgxLA2vXkUu'
access_token_secret = 'ydwhzznI5JND5w2ff9ZdIrB8Lu0LSXgHPrW07QiGMmcaa'

global contador
contador = 0

print ("--------TENGO %i ------------" % contador)



class StdOutListener(StreamListener):
    """ A listener handles tweets that are received from the stream.
    This is a basic listener that just prints received tweets to stdout.
    """
    def on_data(self, data):
        _data = json.loads(data)
        global contador
        contador = contador+1
        print ("--------TENGO %i ------------" % contador)
        archivo = open('corpus2.txt', 'a')
        archivo.write(json.dumps(_data, indent=4, sort_keys=True))
        #print (json.dumps(_data, indent=4, sort_keys=True))
        archivo.close()
        return True

    def on_error(self, status):
        print(status)

if __name__ == '__main__':
    auth = OAuthHandler(consumer_key, consumer_secret)
    auth.set_access_token(access_token, access_token_secret)

    #listener_01 = StdOutListener()
    #stream_01 = Stream(auth, listener_01)
    #stream_01.filter(track=['GiorgioJackson'])

    listener = StdOutListener()
    stream = Stream(auth, listener)
    stream.filter(track=["Karolcariola","GiorgioJackson","SenadorGuillier","felipeharboe","camila_vallejo","gabrielboric","gustavohasbun","senadornavarro","ivanmoreirab","Chile_Vamos_","felipeharboe","NuevaMayoriacl","ceciperez1","urrutiaosvaldo","ignaciowalker","lautarocarmona","RojoEdwards","Hugo_Gutierrez_","marconunez","iallendebussi"])







