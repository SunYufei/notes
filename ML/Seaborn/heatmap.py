import seaborn as sns
import matplotlib.pyplot as plt

ticks23 = ['手机', '电脑', '冰箱', '空调',
           '电风扇', '电水壶', '按摩器', '电磁炉',
           '电暖器', '吸尘器', '电熨斗', '搅拌机',
           '投影仪', '电灯', '电锅', '加湿器',
           '碎纸机', '电视', '抽油烟机', '微波炉',
           '烤箱', '饮水机', '吹风机']

ticks12 = ['电风扇', '吹风机', '电灯', '干衣机', '电饼铛', '电火锅', '烤箱', '电暖气', '水壶', '饮水机', '熨斗', '抽油烟机']

sheet1 = [[1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
          [0, 0.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
          [0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
          [0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
          [0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
          [0, 0, 0, 0, 0, 0.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
          [0, 0, 0, 0, 0, 0, 0.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
          [0, 0, 0, 0, 0, 0, 0, 0.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
          [0, 0, 0, 0, 0, 0, 0, 0, 0.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
          [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
          [0, 0, 0, 0, 0, 0.16, 0, 0, 0, 0, 0.84, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
          [0, 0, 0, 0, 0, 0.08, 0, 0, 0, 0, 0, 0.9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
          [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
          [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0],
          [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0],
          [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0],
          [0, 0, 0, 0, 0, 0.01, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.98, 0, 0, 0, 0, 0, 0],
          [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
          [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0],
          [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0],
          [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
          [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0],
          [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1]]

m1201 = [[1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1]]

m1202 = [[1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0.51, 0.28, 0, 0, 0, 0, 0.21, 0, 0],
         [0, 0, 0, 0.18, 0.51, 0.01, 0, 0, 0, 0.29, 0, 0],
         [0, 0, 0, 0, 0, 0.99, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0.03, 0.05, 0.75, 0, 0, 0.15, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0.99, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0.02, 0, 0, 0.98, 0, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 0, 0.92, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1]]

vi = [[0.97, 0.03, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
      [0, 0.93, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.07, 0, 0, 0, 0, 0],
      [0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
      [0.02, 0, 0.22, 0.41, 0.11, 0, 0.07, 0, 0, 0.11, 0, 0, 0, 0, 0, 0, 0, 0.03, 0, 0, 0, 0, 0.03],
      [0, 0, 0, 0, 0.92, 0, 0, 0, 0, 0, 0, 0.08, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
      [0, 0, 0, 0, 0, 0.48, 0, 0, 0.15, 0, 0.08, 0, 0, 0, 0.08, 0.02, 0, 0, 0, 0, 0.08, 0.11, 0],
      [0, 0, 0, 0, 0, 0, 0.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
      [0, 0, 0, 0, 0, 0, 0, 0.98, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.01, 0, 0, 0, 0],
      [0.01, 0, 0, 0, 0, 0.22, 0, 0, 0.41, 0, 0.18, 0, 0, 0.03, 0.02, 0, 0, 0, 0, 0, 0.06, 0.07, 0],
      [0, 0, 0, 0, 0, 0.02, 0, 0, 0, 0.92, 0.01, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.03, 0.02, 0],
      [0.02, 0.01, 0, 0, 0, 0.16, 0, 0, 0.08, 0, 0.53, 0, 0, 0.03, 0.01, 0, 0, 0, 0, 0, 0.07, 0.05, 0.03],
      [0, 0, 0, 0, 0.11, 0, 0, 0, 0, 0, 0, 0.89, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
      [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
      [0, 0, 0, 0, 0, 0.07, 0, 0, 0.06, 0, 0, 0, 0, 0.68, 0.06, 0, 0, 0, 0, 0, 0.05, 0.08, 0],
      [0, 0, 0, 0, 0, 0.1, 0, 0, 0.09, 0, 0.08, 0, 0, 0, 0.66, 0, 0, 0, 0, 0, 0, 0.07, 0],
      [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0],
      [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.99, 0, 0, 0, 0, 0, 0],
      [0, 0.11, 0.08, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.8, 0, 0, 0, 0, 0],
      [0, 0, 0, 0, 0.12, 0, 0, 0, 0, 0, 0, 0.21, 0, 0, 0, 0, 0, 0, 0.67, 0, 0, 0, 0],
      [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.99, 0, 0, 0],
      [0, 0, 0, 0, 0, 0.11, 0, 0, 0.08, 0, 0.08, 0, 0, 0.05, 0.03, 0, 0, 0, 0, 0, 0.55, 0.08, 0.01],
      [0.13, 0, 0, 0, 0, 0.07, 0, 0, 0.07, 0, 0.06, 0, 0, 0.02, 0.05, 0, 0, 0, 0, 0, 0.03, 0.57, 0],
      [0, 0, 0, 0, 0, 0.04, 0, 0, 0.08, 0, 0.05, 0, 0, 0, 0.09, 0, 0, 0, 0, 0, 0.07, 0.05, 0.62]]

inception23 = [[1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
               [0.02, 0, 0.03, 0.84, 0.03, 0, 0.02, 0, 0, 0, 0, 0, 0, 0, 0.05, 0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0.97, 0, 0, 0, 0, 0.03, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0.03, 0, 0, 0.95, 0, 0, 0, 0, 0, 0.01, 0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0.1, 0, 0, 0.01, 0, 0.88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0.09, 0, 0, 0, 0, 0, 0.91, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.99, 0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0.01, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.98, 0, 0, 0, 0, 0, 0],
               [0, 0.02, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.98, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.99, 0, 0, 0],
               [0, 0, 0, 0, 0, 0.02, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.98, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0],
               [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.03, 0, 0, 0, 0, 0, 0, 0, 0.96]]

cnn23 = [[0.97, 0, 0, 0, 0, 0, 0.03, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 0.8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.11, 0.09, 0, 0, 0, 0, 0],
         [0, 0, 0.96, 0.02, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.01, 0, 0, 0, 0],
         [0, 0, 0.08, 0.73, 0.08, 0, 0, 0, 0, 0.02, 0, 0, 0, 0, 0.04, 0, 0.01, 0, 0.03, 0, 0, 0, 0.01],
         [0, 0, 0, 0, 0.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0.8, 0, 0, 0, 0, 0.07, 0, 0, 0, 0.08, 0, 0, 0, 0.05, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0, 0.98, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.01, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0.05, 0, 0, 0.9, 0, 0.02, 0, 0, 0, 0.01, 0, 0, 0, 0, 0, 0, 0.01, 0],
         [0, 0, 0, 0.02, 0, 0.03, 0, 0, 0, 0.88, 0, 0, 0, 0, 0, 0, 0, 0, 0.07, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0.03, 0, 0, 0.02, 0, 0.87, 0, 0, 0, 0, 0.05, 0, 0, 0, 0, 0, 0.01, 0.01],
         [0, 0, 0, 0, 0, 0.11, 0, 0, 0, 0, 0, 0.88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.98, 0, 0, 0, 0, 0, 0, 0, 0.02, 0],
         [0, 0, 0, 0, 0, 0.07, 0, 0, 0, 0, 0.05, 0, 0, 0, 0.83, 0, 0, 0, 0, 0, 0, 0.05, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.05, 0, 0, 0, 0, 0.95, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0.07, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.92, 0, 0, 0, 0, 0, 0],
         [0, 0.09, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.9, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0.12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.87, 0, 0, 0, 0],
         [0, 0, 0, 0.03, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.97, 0, 0, 0],
         [0, 0, 0, 0, 0, 0.08, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.92, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 0.04, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.03, 0.91, 0.02],
         [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.09, 0, 0, 0, 0.01, 0, 0, 0, 0.89]]


def draw(con_mat, ticks):
    sns.set(font='SimHei')

    if ticks == ticks23:
        fig, ax = plt.subplots(figsize=(13, 8))
    else:
        fig, ax = plt.subplots(figsize=(11, 8))
    ax.tick_params(labelsize=15)

    sns.heatmap(con_mat,
                ax=ax,
                annot=True,
                cmap='GnBu',
                xticklabels=ticks,
                yticklabels=ticks,
                linewidths=0.5,
                linecolor='darkgray',
                robust=False)

    plt.show()


# draw(sheet1, ticks23)
# draw(m1201, ticks12)
# draw(m1202, ticks12)
# draw(vi, ticks23)
# draw(inception23, ticks23)
draw(cnn23, ticks23)
