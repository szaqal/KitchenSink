#! /usr/bin/env python3
from jira import JIRA

options = {"server": "https://jira.atlassian.com"}
jira = JIRA(options = options,  basic_auth=('abc', '123'))
print(jira)
