import 'dart:convert';
//import 'dart:js';
import 'package:cryptoapk/coin_details.dart';
import 'package:cryptoapk/coin_graph_screen.dart';
import 'package:cryptoapk/update_screen_profile.dart';
import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:http/http.dart' as http ;



class HomeScreen extends StatefulWidget {
   const HomeScreen({Key? key}) : super(key: key);

   @override
   State<HomeScreen> createState() => _HomeScreenState();
}





class _HomeScreenState extends State<HomeScreen>{
  String url=  "https://api.coingecko.com/api/v3/coins/markets?vs_currency=inr&order=market_cap_desc&per_page=100&page=1&sparkline=false";
  String name= "", email= "";
  final GlobalKey<ScaffoldState> _globalKey= GlobalKey<ScaffoldState>();
  List<CoinDetailsModel> coinDetailsList =[];
  bool isFirstTimeDataAccess =true;
  late Future<List<CoinDetailsModel>> coinDetailsFuture;
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    getUserDetails();
    coinDetailsFuture= getCoinsDetails();
  }

  void getUserDetails() async{
    SharedPreferences prefs = await SharedPreferences.getInstance();
    setState(() {
      name=prefs.getString('name')?? "";
      email=prefs.getString('email')?? "";
    });
  }

  Future<List<CoinDetailsModel>> getCoinsDetails() async {
    Uri uri =Uri.parse(url);
    final response = await http.get(uri);
    if(response.statusCode ==200 || response.statusCode==201){
      List coinsData = json.decode(response.body);
      List<CoinDetailsModel> data =coinsData.map((e) => CoinDetailsModel.fromJson(e)).toList();
      return data;
    }else{
      return <CoinDetailsModel>[];
    }
  }
@override
   Widget build(BuildContext context) {
     return  Scaffold(
       key: _globalKey,
       appBar: AppBar(
         leading: IconButton(
           onPressed: (){
             _globalKey.currentState!.openDrawer();
           },
             icon: const Icon(Icons.menu,color: Colors.black,),
         ),
         backgroundColor: Colors.white,
         elevation: 0,
          title:const Text('Crypto Tracker',style: TextStyle(color: Colors.black),),
       ),
       drawer: Drawer(
         child: Column(
           children: [
             UserAccountsDrawerHeader(
                 accountName: Text(
                   name,
                 style: const TextStyle(
                   fontWeight: FontWeight.w500,
                   fontSize: 18,
                  ),
                 ),
                 accountEmail: Text(
                  email,
                   style: const TextStyle(
                       fontWeight: FontWeight.w500,
                       fontSize: 17,
                   ),
                 ),
                 currentAccountPicture: const Icon(Icons.account_circle,
                 size: 70.0,
                   color: Colors.white,
                 ),
             ),
             ListTile(
               onTap: (){
                 Navigator.push(context,
                     MaterialPageRoute(
                     builder: (context)=>UpdateProfileScreen(),
                  ),
                 );
               },
               leading: const Icon(Icons.account_box),
               title: const Text('Update Profile',
               style: TextStyle(
                 fontSize: 18.0,
               ),
               ),
             )
           ],
         ),
       ),
       body: FutureBuilder(
           future: coinDetailsFuture,
           builder: (context,AsyncSnapshot<List<CoinDetailsModel>> snapshot ){
         if(snapshot.hasData){
           if(isFirstTimeDataAccess){
             coinDetailsList= snapshot.data!;
             isFirstTimeDataAccess =false;
           }
           return Column(
              children: [
                Padding(padding: const EdgeInsets.symmetric(
                  vertical: 15.0,
                  horizontal: 20.0,
                ),
                  child: TextField(
                    onChanged: (query){
                      List<CoinDetailsModel> searchResult=
                      snapshot.data!.where((element){
                        String coinName =element.name.toString();
                        bool isItemFound =coinName.contains(query);
                        return isItemFound;
                      }).toList();
                      setState(() {
                        coinDetailsList= searchResult;
                      });
                    },
                    decoration: InputDecoration(
                      prefixIcon:const Icon(Icons.search) ,
                      border: OutlineInputBorder(
                        borderRadius: BorderRadius.circular(30.0),
                      ),
                      hintText: 'Search for a coin',
                    ),
                  ),
                ),
                Expanded(child: coinDetailsList.isEmpty ? const Center(child: Text("OPP's No result found"),
             )
                : ListView.builder(

             itemCount: coinDetailsList.length,
             itemBuilder: (context ,index){
             return coinDetails(coinDetailsList[index]);
             },
             ),

                ),
              ],
           );
         }
         else{
           return const Center(
             child: CircularProgressIndicator(),
           );
         }
        }
       )

     );
   }
  Widget coinDetails(CoinDetailsModel model){
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 10.0),
      child: ListTile(
        onTap: (){
          Navigator.push(context, MaterialPageRoute(builder:
              (context)=>CoinGraphScreen(coinId: model.id.toString()
                  , coinName: model.name.toString())));
        },
        leading: SizedBox(
          height: 50.0,
          width: 50.0,
          child:  Image.network(model.image.toString()),
        ),
        title: Text("${model.name}\n${model.symbol}",
          style: const TextStyle(
            fontSize: 17.0,
            fontWeight: FontWeight.w500,
          ),
        ),
        trailing:RichText(
          textAlign: TextAlign.end,
          text: TextSpan(
              text: "Rs.${model.currentprice}\n",
              style: const TextStyle(
                fontSize: 17.0,
                fontWeight: FontWeight.w500,
                color: Colors.black,
              ),
              children: [
                TextSpan(
                  text: "${model.pricechangepercentage24h}",
                  style: const TextStyle(
                    fontSize: 17.0,
                    fontWeight: FontWeight.w500,
                    color: Colors.red,
                  ),
                )
              ]
          ),

        ),
      ),

    );
  }
 }

