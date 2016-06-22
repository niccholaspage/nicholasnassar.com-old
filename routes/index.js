var express = require('express');
var stylus = require('stylus');
var router = express.Router();

var projects = [
    {
        title: "InfiniGrow",
        description: "An endless runner where you try to escape sheeple - Welcome to InfiniGrow!",
        linkText: "Take me to Ludum Dare!",
        link: "http://ludumdare.com/compo/ludum-dare-34/?action=preview&uid=3502",
        background: "infinigrow.png"
    },
    {
        title: "nPlay",
        description: "A website that allows you to watch videos together with friends",
        linkText: "To the website!",
        link: "http://nplay.me",
        background: "nplay.png"
    },
    {
        title: "nNinja",
        description: "A sweet Ninja game that is in the works",
        linkText: "Let me download it!",
        link: "http://nninja.xyz",
        background: "nninja.png"
    },
    {
        title: "The Spooky Dungeon",
        description: "A revolutionary graphical RPG with multiplayer and a lot of text!",
        linkText: "Take me to the website!",
        link: "http://thespookydungeon.com/",
        background: "thespookydungeon.png"
    },
    {
        title: "Music Bot",
        description: "A Teamspeak music bot written in Java with the Spark framework",
        linkText: "To GitHub!",
        link: "https://github.com/niccholaspage/MusicBot",
        background: "music-bot.png"
    },
    {
        title: "nicholasnassar.com",
        description: "The website you are currently on! Created with NodeJS, Express, Pug, and Stylus.",
        linkText: "The GitHub Project",
        link: "https://github.com/niccholaspage/nicholasnassar.com",
        background: "../../favicon.ico"
    },
    {
        title: "nRPG",
        description: "A huge Minecraft modification that adds in classes, skills, dungeons, and custom items into the game",
        linkText: "Link will come one day",
        link: "#",
        background: "nrpg-logo.png"
    },
    {
        title: "IMBAbuilds Android App",
        description: "The official app for IMBAbuilds that allows you to browse Starcraft II builds!",
        linkText: "To GitHub!",
        link: "http://github.com/niccholaspage/IMBAbuilds",
        background: "imbabuilds.png"
    },
    {
        spacing: true
    },
    {
        title: "Fe",
        description: "An economy plugin for Minecraft",
        linkText: "To BukkitDev!",
        link: "http://dev.bukkit.org/bukkit-plugins/fe-economy",
        background: "fe.png"
    },
    {
        title: "nChildhood",
        description: "A game that probably shouldn't exist",
        linkText: "Work in Progress",
        link: "#",
        background: "#"
    }
];

var jobs = [
    {
        name: "Kids Unlimited",
        link: "http://www.kidsunlimitedtoledo.org/",
        time: "January 2016 - May 2016",
        skills: "Tutoring",
        experience: "I tutored students from Kindergarden through 8th grade for two hours every week."
    },
    {
        name: "Oriental Rug Galaxy",
        link: "http://orientalruggalaxy.com/",
        time: "June 2015 - Now",
        skills: "Java, NodeJS, HTML, CSS",
        experience: "I manage five online stores and have created a Java program to automate the inventory updating and exporting across all services."
    }
];

/* GET home page. */
router.get('/', function (req, res, next) {
    res.render('index', { projects: projects, jobs: jobs });
});

module.exports = router;
