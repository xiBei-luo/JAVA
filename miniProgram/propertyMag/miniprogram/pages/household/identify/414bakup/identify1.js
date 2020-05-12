
//https://blog.csdn.net/u013344993/article/details/83502068

Page({

  /**
   * 页面的初始数据
   */
  data: {
    objectMultiShow: [],
    objectMultiArray: [],
    multiArray: [],
    multiIndex: [],
    checkeIndex: []
  },

  /**
   * 生命周期函数--监听页面加载
   * objectMultiShow--匹配多列选择器渲染数据所对应的json数据（包含id，parentId，name）
   * multiArray--多列选择器渲染数据
   */
  onLoad: function (options) {
    // 初始化
    let data = {
      objectMultiShow: this.data.objectMultiShow,
      objectMultiArray: this.data.objectMultiArray,
      multiArray: this.data.multiArray,
      multiIndex: this.data.multiIndex,
      checkeIndex: this.data.checkeIndex
    }
    data.objectMultiArray = [
      [{ id: 0, name: '无脊柱动物' }, { id: 1, name: '脊柱动物' }],
      [
        { id: 0, name: '扁性动物', parentId: 0 }, { id: 1, name: '线形动物', parentId: 0 }, { id: 2, name: '环节动物', parentId: 0 }, { id: 3, name: '软体动物', parentId: 0 }, { id: 4, name: '节肢动物', parentId: 0 },
        { id: 5, name: '鱼', parentId: 1 }, { id: 6, name: '两栖动物', parentId: 1 }, { id: 7, name: '爬行动物', parentId: 1 }
      ],
      [
        { id: 0, name: '猪肉绦虫', parentId: 0 }, { id: 1, name: '吸血虫', parentId: 0 },
        { id: 2, name: '蛔虫', parentId: 1 },
        { id: 3, name: '蚂蚁', parentId: 2 }, { id: 4, name: '蚂蟥', parentId: 2 },
        { id: 5, name: '河蚌', parentId: 3 }, { id: 6, name: '蜗牛', parentId: 3 }, { id: 7, name: '蛞蝓', parentId: 3 },
        { id: 8, name: '昆虫', parentId: 4 }, { id: 9, name: '甲壳动物', parentId: 4 }, { id: 10, name: '蛛形动物', parentId: 4 }, { id: 11, name: '多足动物', parentId: 4 },
        { id: 3, name: '鲫鱼', parentId: 5 }, { id: 4, name: '带鱼', parentId: 5 },
        { id: 3, name: '青蛙', parentId: 6 }, { id: 4, name: '娃娃鱼', parentId: 6 },
        { id: 3, name: '蜥蜴', parentId: 7 }, { id: 4, name: '龟', parentId: 7 }, { id: 4, name: '壁虎', parentId: 7 },
      ]
    ]
    data.objectMultiShow = data.objectMultiArray.map((item, index) => {
      if (index > 0) {
        item = item.filter(i => i.parentId === data.objectMultiArray[index - 1][0].id)
      }
      return item
    })
    data.multiArray = data.objectMultiShow.map(item => {
      item = item.map(i => i.name)
      return item
    })
    console.log(data.multiIndex)
    // 数据更新
    this.setData(data)
  },

  bindMultiPickerChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      multiIndex: e.detail.value
    })
  },
  bindMultiPickerColumnChange: function (e) {
    console.log('修改的列为', e.detail.column, '，值为', e.detail.value);
    // 初始化数据
    var data = {
      objectMultiShow: this.data.objectMultiShow,
      multiArray: this.data.multiArray,
      multiIndex: this.data.multiIndex
    };

    // 改变第i列数据之后，后几列选择第0个选项（重置）
    data.multiIndex[e.detail.column] = e.detail.value;
    for (let i = e.detail.column; i < data.multiIndex.length - 1; i++) {
      data.multiIndex[i + 1] = 0
    }

    /**
     * 改变第i列数据之后，后几列数据更新
     * 两种写法：for 和 switch，switch为三列选择器写法，for由switch精简拓展过来，可用于多列选择器
     * swich写法：如果更改的是第一列数据，第二列数据通过filter筛选（parentId = 第一列选中项id），同时更新第三列数据
     *            如果更改的是第二列数据，更新第三列数据 通过filter筛选（parentId = 第二列选中项id）
     */
    let arry = this.data.objectMultiArray
    for (let i = e.detail.column; i < data.multiIndex.length - 1; i++) {
      data.objectMultiShow[i + 1] = arry[i + 1].filter(item => item.parentId === data.objectMultiShow[i][data.multiIndex[i]].id)
      data.multiArray[i + 1] = data.objectMultiShow[i + 1].map(item => item.name)
    }
    /*switch (e.detail.column) {
      case 0:
        data.objectMultiShow[1] = arry[1].filter(item => item.parentId === data.objectMultiShow[0][data.multiIndex[0]].id)
        data.multiArray[1] = data.objectMultiShow[1].map(item => item.name)
        data.objectMultiShow[2] = arry[2].filter(item => item.parentId === data.objectMultiShow[1][data.multiIndex[1]].id)
        data.multiArray[2] = data.objectMultiShow[2].map(item => item.name)
        break;
      case 1:
        data.objectMultiShow[2] = arry[2].filter(item => item.parentId === data.objectMultiShow[1][data.multiIndex[1]].id)
        data.multiArray[2] = data.objectMultiShow[2].map(item => item.name)
    }*/
    // 数据更新
    this.setData(data);
  }
})