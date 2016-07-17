<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Continuous delivery and Integration - User</title>

<style type="text/css">
@import url(http://fonts.googleapis.com/css?family=Lato:400,700);

body {
	background: #3891CC;
	font-family: 'Lato', sans-serif;
	color: #FDFCFB;
	text-align: justify;
	font-size: 20px;
	letter-spacing: 1px;
	line-height: 1.3em;
	color:
}

hr {
	background: #dedede;
	border: 0;
	height: 1px;
}

.wrap {
	width: 1000px;
	margin: 12% auto;
}

nav.menu ul {
	border-radius: 5px 5px 5px 5px;
	overflow: hidden;
	width: 100%;
	padding: 0;
	margin: 0 0 0;
	list-style: none;
	color: #fff;
	background: #1a78c2;
	-webkit-box-shadow: 1px 1px 1px 0px rgba(204, 204, 204, 0.55);
	-moz-box-shadow: 1px 1px 1px 0px rgba(204, 204, 204, 0.55);
	box-shadow: 1px 1px 1px 0px rgba(204, 204, 204, 0.55);
}

nav.menu ul li {
	float: left;
	margin: 0;
}

nav.menu ul a {
	display: block;
	padding: 25px;
	font-size: 16px;
	font-weight: 600;
	text-transform: uppercase;
	color: #fff;
	text-decoration: none;
	transition: all 0.5s ease;
}

nav.menu ul a:hover {
	background: #d45d7d;
	text-decoration: underline;
}

.blog {
	width: 100%;
}

.content {
	border-radius: 5px 5px 5px 5px;
	margin: 25px auto;
	padding: 25px;
	background: #fff;
	border: 1px solid #dedede;
	font-color: #fdfcfb;
}

.content img {
	margin: 0 0 25px 0;
	max-width: 600px;
	min-width: 600px;
	max-height: 350px;
}

.content h1 {
	margin: 0 0 15px;
	padding: 0;
	font-family: Georgia;
	font-weight: normal;
	color: #3891CC;
	text-align: start;
}

.content p {
	font-family: Lato;
	font-weight: normal;
	color: #666;
}

.content p:last-child {
	margin: 0;
}

.content .content-more {
	color: #000;
	font-weight: 700;
	text-decoration: none;
	transition: all 0.5s ease;
}

.content .content-more:hover {
	margin-left: 10px;
}
</style>
</head>
<body>
	<div class="wrap">
	<h1>${message}!!</h1><br><br>
	
		<nav class="menu">
			<ul>
				<li><a href="#">Home</a></li>
			</ul>
		</nav>

		<div class="blog">
			<div class="content">

				<img
					src="http://fresherbook.co.in/wp-content/uploads/2013/07/ntt.jpg">
				<h1>NTT DATA</h1>
				<hr>
				<p>NTT DATA Corporation is a Japanese system integration company
					and a subsidiary of NTT (Nippon Telegraph and Telephone) Group.
					Nippon Telegraph and Telephone Public Corporation, a predecessor of
					NTT, started Data Communications business in 1967. NTT, following
					its privatization in 1985, spun off the Data Communications
					division as NTT DATA in 1988, which has now become the largest of
					the IT Services companies headquartered in Japan.</p>
				<p>NTT DATA is a publicly traded company, but is about 54
					percent owned by NTT. Its business areas are in national and local
					governments, financial, and telecommunication sectors. According to
					reports in 2012, Forbes Global 2000 recognizes NTT DATA as the 5th
					largest IT Services company.</p>
				<a href="http://en.wikipedia.org/wiki/NTT_DATA" class="content-more">Read
					more..</a>
			</div>
			<div class="content">
				<img
					src="http://americas.nttdata.com/~/media/Images/Services/Cloud-Strategy.png">
				<h1>NTT Data opens cloud services command center</h1>
				<hr>

				<p>IT services provider NTT DATA, on Tuesday, opened an advanced
					cloud services command centre here. The state-of-the-art Global
					Service Operations Centre (GSoC) will support customers in remote
					and cloud IT infrastructure and applications management.</p>
				<p>NTT DATA Senior Vice-President (Cloud Services) Kannan
					Ramamani said the Bengaluru facility was truly global in nature,
					and gave high priority to security while supporting clients
					worldwide.</p>
				<a
					href="http://www.thehindu.com/business/Industry/ntt-data-opens-cloud-services-command-centre/article6827170.ece"
					class="content-more">Read more..</a>
			</div>
			<div class="content">
				<img src="images/Ntercept.gif">
				<h1>NTT Data launches Ntercept personal safety mobile app</h1>
				<hr>

				<p>IT services provider, NTT Data has announced the availability
					of Ntercept, a mobile app developed to provide personal safety
					assistance to victims during a crisis situation. The app has been
					released during the Nasscom's Diversity and Inclusion Summit 2015
					in Bangalore, India, on 22 January.</p>
				<p>Ntercept was originally created as part of an innovation
					initiative supporting female employees' safety in India, one of the
					company's largest employee bases. Ntercept is now publically
					available in both India and the US, and both Android and iOS
					versions of the app are available and can be downloaded from Google
					Play and the Apple App Store. A Windows version is currently in
					development.</p>
				<p>The Ntercept mobile app, once triggered, makes an emergency
					call and simultaneously sends text messages to a person's
					designated SOS contact list. The SOS message will then be sent
					every two minutes with a distress message and the current location
					of the user. The app also records the voice conversation at the
					site.</p>
				<a
					href="http://www.telecompaper.com/news/ntt-data-launches-ntercept-personal-safety-mobile-app--1061153"
					class="content-more">Read more..</a>
			</div>
		</div>
	</div>
</body>
</html>