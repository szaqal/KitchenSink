# Basics #



## Strings ##

```
>>> """
... multiline """
'\nmultiline '
```

Mulitply String 

```
>>> 3 * 'a'
'aaa'

```

```
>>> a = 'test'
>>> a[2]
's'
>>> a[1:3]
'es'

```

## Lists ##

```
>>> a =  [1,2,3]
>>> a[0]
1
```


## Loops ##


Foreach

```
>>> words = ['cat', 'window', 'defenestrate']
>>> for w in words:
...     print w;
... 
cat
window
defenestrate
```

Range

```
>>> range(10)
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
```

## Lambdas ##

```
>>> def make_incrementor(n):
...     return lambda x: x+n
... 
>>> f = make_incrementor(10)
>>> f(10);
20

```


## Standard Library ##

* **import os**
* **import shutil** directory management task
* **import sys** command line args
* **import re** regex etc
* **import math** maths
* **import random** rand
* **import urllib/smtp lib**



