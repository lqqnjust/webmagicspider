-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2018-07-02 02:34:27
-- 服务器版本： 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `doubangroup`
--

-- --------------------------------------------------------

--
-- 表的结构 `image`
--

CREATE TABLE `image` (
  `topicid` varchar(100) COLLATE utf8_bin NOT NULL,
  `url` varchar(200) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `image`
--

INSERT INTO `image` (`topicid`, `url`) VALUES
('112675661', 'https://img1.doubanio.com/view/group_topic/large/public/p117597158.jpg'),
('117616187', 'https://img1.doubanio.com/view/group_topic/large/public/p119287069.jpg'),
('119162229', 'https://img1.doubanio.com/view/group_topic/large/public/p123619517.jpg'),
('119162229', 'https://img1.doubanio.com/view/group_topic/large/public/p123619579.jpg'),
('112675661', 'https://img1.doubanio.com/view/group_topic/large/public/p124104657.jpg'),
('119337016', 'https://img1.doubanio.com/view/group_topic/large/public/p124128858.jpg'),
('119337016', 'https://img1.doubanio.com/view/group_topic/large/public/p124128859.jpg'),
('119367871', 'https://img1.doubanio.com/view/group_topic/large/public/p124134737.jpg'),
('119473988', 'https://img1.doubanio.com/view/group_topic/large/public/p124425329.jpg'),
('119618516', 'https://img1.doubanio.com/view/group_topic/large/public/p124821979.jpg'),
('119624916', 'https://img1.doubanio.com/view/group_topic/large/public/p124835539.jpg'),
('114714759', 'https://img3.doubanio.com/view/group_topic/large/public/p111547530.jpg'),
('113735678', 'https://img3.doubanio.com/view/group_topic/large/public/p115745213.jpg'),
('116589029', 'https://img3.doubanio.com/view/group_topic/large/public/p116373963.jpg'),
('119162229', 'https://img3.doubanio.com/view/group_topic/large/public/p123619574.jpg'),
('119240201', 'https://img3.doubanio.com/view/group_topic/large/public/p123809430.jpg'),
('112675661', 'https://img3.doubanio.com/view/group_topic/large/public/p124104651.jpg'),
('119337016', 'https://img3.doubanio.com/view/group_topic/large/public/p124133225.jpg'),
('119367871', 'https://img3.doubanio.com/view/group_topic/large/public/p124134736.jpg'),
('112675661', 'https://img3.doubanio.com/view/group_topic/large/public/p124227005.jpg'),
('119478056', 'https://img3.doubanio.com/view/group_topic/large/public/p124432806.jpg'),
('119496895', 'https://img3.doubanio.com/view/group_topic/large/public/p124486774.jpg'),
('119478210', 'https://img3.doubanio.com/view/group_topic/large/public/p124500920.jpg'),
('119548040', 'https://img3.doubanio.com/view/group_topic/large/public/p124627934.jpg'),
('112675661', 'https://img3.doubanio.com/view/group_topic/large/public/p124754921.jpg'),
('119600536', 'https://img3.doubanio.com/view/group_topic/large/public/p124774075.jpg'),
('119621046', 'https://img3.doubanio.com/view/group_topic/large/public/p124827771.jpg'),
('119626839', 'https://img3.doubanio.com/view/group_topic/large/public/p124838410.jpg'),
('119628100', 'https://img3.doubanio.com/view/group_topic/large/public/p124840073.jpg'),
('119628562', 'https://img3.doubanio.com/view/group_topic/large/public/p124840873.jpg'),
('115282102', 'https://img3.doubanio.com/view/group_topic/large/public/p124841283.jpg');

-- --------------------------------------------------------

--
-- 表的结构 `topic`
--

CREATE TABLE `topic` (
  `title` varchar(200) COLLATE utf8_bin NOT NULL,
  `topicid` varchar(100) COLLATE utf8_bin NOT NULL,
  `author` varchar(100) COLLATE utf8_bin NOT NULL,
  `profile` varchar(200) COLLATE utf8_bin NOT NULL,
  `content` text COLLATE utf8_bin NOT NULL,
  `groupid` varchar(100) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `topic`
--

INSERT INTO `topic` (`title`, `topicid`, `author`, `profile`, `content`, `groupid`) VALUES
(' 【晒】睡觉咯！ ', '112675661', 'Sssandra', 'https://www.douban.com/people/78553867/', '', 'haixiuzu'),
(' 【晒】夏天来啦 ', '113735678', '可温柔', 'https://www.douban.com/people/160008781/', '', 'haixiuzu'),
(' 【晒】明天又可以去海水里浪啦 ', '114714759', '兜兜', 'https://www.douban.com/people/163266838/', '', 'haixiuzu'),
(' 【晒】点什么好 ', '115282102', '韩丁丁', 'https://www.douban.com/people/157819304/', '', 'haixiuzu'),
(' 【晒】居然有人说喜欢……捂脸 ', '116589029', '芒果布丁', 'https://www.douban.com/people/150047518/', '', 'haixiuzu'),
(' 【晒】红衣女鬼 ', '119162229', 'A', 'https://www.douban.com/people/PansyAA/', '', 'haixiuzu'),
(' 【晒】第一次穿JK出街~果然不一样 ', '119240201', '熊酱', 'https://www.douban.com/people/52583877/', '感觉好羞射哈~', 'haixiuzu'),
(' 【晒】这样微胖不好吗╭(°A°`)╮ ', '119337016', '泽尻由美子正版', 'https://www.douban.com/people/96969241/', '我们一直要努力', 'haixiuzu'),
(' 【晒】 ', '119367871', '路人甲', 'https://www.douban.com/people/116259801/', '', 'haixiuzu'),
(' 【晒】想听骚话 ', '119473988', 'S', 'https://www.douban.com/people/83317809/', '', 'haixiuzu'),
(' 【晒】岩 ', '119478056', 'Fomalhaut', 'https://www.douban.com/people/39563791/', '', 'haixiuzu'),
(' 【晒】试衣间 ', '119478210', 'kiss me', 'https://www.douban.com/people/151431596/', '前男友的旧手机里发现了我的旧照片', 'haixiuzu'),
(' 【晒】旗袍 ', '119496895', '甜', 'https://www.douban.com/people/164634788/', '小哥哥打针吗？', 'haixiuzu'),
(' 【晒】午睡醒来发现被袭xiong ', '119548040', '小满褥', 'https://www.douban.com/people/75286419/', '', 'haixiuzu'),
(' 【晒】情绪 ', '119600536', '涟漪一片片泛起', 'https://www.douban.com/people/92401293/', '更多 更多', 'haixiuzu'),
(' 【 晒 】新裙子 ', '119618516', 'Kim BoA', 'https://www.douban.com/people/junBoA/', '今日着装最佳.', 'haixiuzu'),
(' 大晚上好无聊 ', '119621046', 'MintGreen', 'https://www.douban.com/people/nothing_on_uyou/', '', 'haixiuzu'),
(' landing xiamen ', '119624916', '远机位', 'https://www.douban.com/people/84989875/', '', 'haixiuzu'),
(' 【晒】艳遇之城 ', '119626839', 'Lst', 'https://www.douban.com/people/136794191/', '', 'haixiuzu'),
(' 小姐姐来语音。 ', '119627430', '容嬷嬷的春天。', 'https://www.douban.com/people/166312764/', '小姐姐！', 'haixiuzu'),
(' 小姐姐来shi pin ', '119627448', '嫪毐学长', 'https://www.douban.com/people/128215436/', '看我昵称', 'haixiuzu'),
(' 自从放了假 这天天熬夜我看是改不过来了 ', '119628100', '大眼萌。', 'https://www.douban.com/people/167428809/', '', 'haixiuzu'),
(' 【晒】老图骗粉 ', '119628562', 'Lst', 'https://www.douban.com/people/136794191/', '', 'haixiuzu'),
(' 【晒】被偷拍 ', '84561041', '楚楚', 'https://www.douban.com/people/139084958/', '', 'haixiuzu');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`url`);

--
-- Indexes for table `topic`
--
ALTER TABLE `topic`
  ADD PRIMARY KEY (`topicid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
