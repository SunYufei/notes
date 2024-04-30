---
lastUpdated: 2019-07-08
---

# PyQt5 显示和业务逻辑分离

> 显示与业务分离，实现界面复用

最近将一段代码改成多进程来测试性能提升情况，需要一个单线程和一个多线程的窗口分别测试，为控制变量，需要保证两个窗口 UI 相同。

## 界面代码

```python
from PyQt5.QtWidgets import *

class UiWindow:
    @staticmethod
    def setup_ui(widget: QWidget):
        widget.setWindowTitle('Window')

        # Main Layout
        layout = QHBoxLayout()
        widget.setLayout(layout)

        # Button 1
        widget.btn_1 = QPushButton('Button 1')
        widget.btn_1.setObjectName('btn_1')
        layout.addWidget(widget.btn_1, 0)

        # Button 2
        widget.btn_2 = QPushButton('Button 2')
        widget.btn_2.setObjectName('btn_2')
        layout.addWidget(widget.btn_2, 0)

        # Button 3
        widget.btn_3 = QPushButton('Button 3')
        widget.btn_3.setObjectName('btn_3')
        layout.addWidget(widget.btn_3, 0)
```

注意：界面部件必须要使用 `setObjectName()`，否则在业务代码中不可见。

## 业务代码

```python
from PyQt5.QtWidgets import QWidget
from ui_window import UiWindow # 引入 UI 类

class Window1(QWidget, UiWindow):
    def __init__(self, *args):
        super(QWidget, self).__init__(*args)
        self.setup_ui(self)

        # 其他业务代码

class Window2(QWidget, UiWindow):
    def __init__(self, *args):
        super(QWidget, self).__init__(*args)
        self.setup_ui(self)

        # 其他业务代码
```
