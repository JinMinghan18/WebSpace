var app = new Vue({
    el: '#app',
    data: {
        city: '杭州',
        weatherList:[]
    },
    methods: {
        searchWeather: function () {
            console.log('天气查询')
            console.log(this.city)
            var that = this;
            axios.get('http://wthrcdn.etouch.cn/weather_mini?city=' +
                  this.city).then(function (resp) {
                      console.log(resp.data.data.forecast);
                      that.weatherList = resp.data.data.forecast;
                  }).catch(function (err) {
                      console.log(err)
                  })
        },
        changeCity:function(city){
            console.log(city);
            this.city = city;
            this.searchWeather();
        }
    }
})
