##Rakennekuvaus

Pelin tärkeimmät luokat ovat Map, Player, Monster ja Bolt. Bolt, Monster ja Player perivät luokan Unit, ja määrittelevät liikkuvat toimijat. Luokalle Map alustetaan lista Monstereita, yksi Player sekä yksi Bolt. Liikkuminen hoidetaan luokalla KeyboardListener, jolle annetaan Map sekä Player, joihin liikkuminen kohdistuu. Luokka AnimationCycle hoitaa animaation, MonsterSpawn uusien monstereiden luomisen ja GameOverScreen hoitaa pelin lopussa näkyvän näytön. Luokka Interface yhdistää edellämainitut luo käyttöliittymän.
