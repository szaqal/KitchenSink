import json

class User:

    firstname="Joe"

    lastname="Doe"

    def format(self):
        return json.dumps([self.firstname, self.lastname])