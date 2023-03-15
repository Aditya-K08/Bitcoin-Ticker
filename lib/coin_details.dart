class CoinDetailsModel {
  late String? id;
  late String? symbol;
  late String? name;
  late String? image;
  late double? currentprice;
  late double? pricechangepercentage24h;

  CoinDetailsModel({
    required this.id,
    required this.symbol,
    required this.name,
    required this.image,
    required this.currentprice,
    required this.pricechangepercentage24h,
  });

  CoinDetailsModel.fromJson(Map<String, dynamic> json) {
    id = json['id'];
    symbol = json['symbol'];
    name = json['name'];
    image = json['image'];
    currentprice = json['current_price'].toDouble();
    pricechangepercentage24h = json['price_change_percentage_24h'];
  }

}

