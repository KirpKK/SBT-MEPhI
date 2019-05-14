## Задание по ansible 

### 1. Склонировать репозиторий
Необходимо склонировать текущий репозиторий локально (ветку `master`)
Запустить `cmd.exe`
Перейти в каталог ansible внутри склонированного репозитория.
Далее пути формируем относительно этого каталога.


### 2. Запуск виртуальных машин
Запускаем `vagrant up`
Проверяем, что виртуальная машина запустилась, а не началась скачка box-а.
Если начался процесс скачивания и он долгий, можно перейти к шагу 2.1
Проверьте, что запускается актуальная версия виртуальной машины (на текущий момент это 3.0.0).


### 2.1 Запуск виртуальных машин - альтернативный способ
Копируем локально `ansible-master.box`
Вызываем `vagrant box add ansible-master.box --name ansible-master` из того же каталога, куда скачали box
Редактируем `Vagrantfile` 
Заменяем `main.vm.box = "ZaitsevSergey/ansible"` на `main.vm.box = "ansible-master"`
Запускаем `vagrant up`


### 3. Подключаемся к виртуальной машине
Запускаем `vagrant ssh`


### 4. Учебные задания
Немного теории:
У вас на рабочих компьютерах запущены 3 виртуалки:
```
master - 192.168.77.10
slave1 - 192.168.77.11
slave2 - 192.168.77.12
```

Запуская `vagrant ssh` вы подключаетесь к `master`.
В каталоге `/home/vagrant/shared` у вас расположена часть репозитория с необходимыми файлами (запустите ls).

Перед началом работы с ansible рекомендую почитать документацию:
https://docs.ansible.com/ansible/latest/user_guide/intro_getting_started.html

Если коротко:
Основная задача ansible - максимально облегчить процесс настройки и управления большим количеством типовых компьютеров.
* Cattle not pets
![Cattle not pets](/img/cattle.png)

Для этого формируются:
* `Inventory` - один или несколько файлов, описывающих конфигурацию серверов
* `Playbook` - файл описывающий действия, которые необходимо произвести над серверами

На master сервере запускается ansible, подключается по ssh к остальным компьютерам и проводит процесс изменения настроек серверов.


### 4.1 Версия ansible
Запустите `ansible --version`
Ожидаемый вывод:
```
```



### 4.2 Inventory файл
Перед началом работы рекомендую прочитать:
https://docs.ansible.com/ansible/latest/user_guide/intro_inventory.html

Основной формат для ansible - yaml. 
Рекомендую прочитать:
https://ru.wikipedia.org/wiki/YAML


Зайдите в каталог `example1`, посмотрите содержимое `inventory.yaml`
Дозаполните файл для slave2

Запустите `ansible -i inventory.yaml -m 'ping'` 
Ожидаемый вывод (для случая корректно заполненного inventory):
```
```

Выше показан пример ad-hoc вызова - вызов одной команды для выбранных серверов.
Детальнее можно почитать тут:
https://docs.ansible.com/ansible/latest/user_guide/intro_adhoc.html


Также выше используется модуль ping. Детальнее:
https://docs.ansible.com/ansible/latest/modules/ping_module.html


### 4.3 Playbook
Перейдите в каталог example2
Запустите `ansible-playbook run_ping.yaml -i inventory.yaml`
Просмотрите содержимое `run_ping.yaml`

Мы сделали то же самое что и выше, но с использованием playbook-ов
Рекомендую прочитать:
https://docs.ansible.com/ansible/latest/user_guide/playbooks.html
https://docs.ansible.com/ansible/latest/cli/ansible-playbook.html

### 4.4 Пример ошибок
Измените в предыдущем примере inventory файл.
Замените `192.168.77.12` на `192.168.77.99`.

Запустите  `ansible-playbook run_ping.yaml -i inventory.yaml`.
Ожидаемый результат - ошибка подключения к одному из 2х серверов.
Обратите внимание, что для другого сервера playbook выполнился.
  
Поправьте `inventory.yaml`


### 4.5 Debug
Рекомендую прочитать:
https://docs.ansible.com/ansible/latest/modules/debug_module.html

Запустите  `ansible-playbook run_debug.yaml -i inventory.yaml`.

Просмотрите содержимое `run_debug.yaml`
Модуль debug позволяет выводить в лог переменные и сообщения.  
Можно задавать или `msg` или `var`

Обратите внимание на `"Система {{ inventory_hostname }}"` в фигурных скобках можно указывать имя переменной или python код.
Результат его вызова будет подставлен в строку.

ansible использует шаблонизатор jinja2 для формирования динамических плейбуков.
Детальнее можно почитать тут:
https://docs.ansible.com/ansible/latest/user_guide/playbooks_templating.html
и тут:
http://jinja.pocoo.org/docs/2.10/


