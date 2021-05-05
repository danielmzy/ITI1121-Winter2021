def checkWork(str1, str2):
    return str1==str2

checkWork(if (outlook is 'sunny') {
  if (humidity is 'high') {
    class = no
  }
  else if (humidity is 'normal') {
    class = yes
  }
}
else if (outlook is 'overcast') {
  class = yes
}
else if (outlook is 'rainy') {
  if (windy is 'FALSE') {
    class = yes
  }
  else if (windy is 'TRUE') {
    class = no
  }
},)