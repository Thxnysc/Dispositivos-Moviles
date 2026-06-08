import 'package:flutter/material.dart';

class PantallaHobbies extends StatelessWidget {
  const PantallaHobbies({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Mis Hobbies'),
        backgroundColor: Colors.purple,
      ),
      body: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text(
              'Mis Actividades Favoritas',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 20),

            // Hobby 1 - Fortnite
            Row(
              children: [
                Icon(Icons.sports_esports, color: Colors.yellow, size: 40),
                const SizedBox(width: 15),
                const Expanded(
                  child: Text(
                    'Jugar Fortnite',
                    style: TextStyle(fontSize: 18),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 15),

            // Hobby 2 - Caminar
            Row(
              children: [
                Icon(Icons.directions_walk, color: Colors.green, size: 40),
                const SizedBox(width: 15),
                const Expanded(
                  child: Text(
                    'Salir a caminar',
                    style: TextStyle(fontSize: 18),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 15),

            // Hobby 3 - Fútbol
            Row(
              children: [
                Icon(Icons.sports_soccer, color: Colors.blue, size: 40),
                const SizedBox(width: 15),
                const Expanded(
                  child: Text(
                    'Jugar Fútbol',
                    style: TextStyle(fontSize: 18),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 15),

            // Hobby 4 - Música
            Row(
              children: [
                Icon(Icons.music_note, color: Colors.pink, size: 40),
                const SizedBox(width: 15),
                const Expanded(
                  child: Text(
                    'Escuchar Música',
                    style: TextStyle(fontSize: 18),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 15),
          ],
        ),
      ),
    );
  }
}