Page({
  data: {
    page: 1,
    pageSize: 20,
    listData: [],
    hiddenLoad: true
  },
  onLoad: function() {
    this.loadData();
    console.log(this.data.listData)
  },
  onReachBottom: function() {
    this.setData({
      hiddenLoad: false,
      page: this.data.page + 1
    });

    if (this.data.listData.length < 100) {
      var that = this;
      setTimeout(function() {
        that.loadData();
      }, 2000);
    } else {
      this.setData({
        hiddenLoad: true
      })
    }
  },
  loadData: function() {
    var tmp = [];
    var initVal = (this.data.page - 1) * this.data.pageSize;
    for (var i = 0; i < 20; i++) {
      tmp.push(initVal + i)
    }
    this.setData({
      hiddenLoad: true,
      listData: this.data.listData.concat(tmp)
    })
  }
})