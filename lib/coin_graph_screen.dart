import 'package:flutter/material.dart';
class CoinGraphScreen extends StatefulWidget {
  final String coinId, coinName;
  const CoinGraphScreen({Key? key ,required this.coinId, required this.coinName}) : super(key: key);

  @override
  State<CoinGraphScreen> createState() => _CoinGraphScreenState();
}

class _CoinGraphScreenState extends State<CoinGraphScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        leading: IconButton(onPressed: (){
          Navigator.pop(context);
        }, icon: Icon(Icons.arrow_back,
          color: Colors.black,
          ),
        ),
        title: Text(widget.coinName,
          style: const TextStyle(
            color: Colors.black,
            fontSize: 18.0,
          ),
        ),
        centerTitle: true,
        elevation: 0,
      ),
      body: SizedBox(
        width: double.infinity,
        child: Column(
          children: [
            RichText(text: TextSpan(
              text:"${widget.coinName} price",
              style: const TextStyle(
                color: Colors.black,
                fontSize: 15.0,
                fontWeight: FontWeight.w500,
              ),
              children: const [
                TextSpan(
                  text: "Rs 1234545.87",
                )
              ]
              ),
            )
          ],
        ),
      ),
    );
  }
}
