-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Апр 20 2018 г., 09:52
-- Версия сервера: 10.0.17-MariaDB
-- Версия PHP: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `childcosmetic`
--

-- --------------------------------------------------------

--
-- Структура таблицы `country_directory`
--

CREATE TABLE `country_directory` (
  `ID` int(11) NOT NULL,
  `CountryName` varchar(300) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Дамп данных таблицы `country_directory`
--

INSERT INTO `country_directory` (`ID`, `CountryName`) VALUES
(1, 'Ukraine'),
(3, 'Russia'),
(4, 'Switherland'),
(5, 'USA');

-- --------------------------------------------------------

--
-- Структура таблицы `manufacturer`
--

CREATE TABLE `manufacturer` (
  `ID` int(11) NOT NULL,
  `FirmName` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `Adress` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `Telephone` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `Website` varchar(300) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Дамп данных таблицы `manufacturer`
--

INSERT INTO `manufacturer` (`ID`, `FirmName`, `Adress`, `Telephone`, `Website`) VALUES
(1, 'Horns and Hoofs', '12, Zoltan st.', '555-34-89', 'HornsAndHoofs.com'),
(2, 'Nesstle', '143, Z avenue', '555-11-22', 'Nesstle.com');

-- --------------------------------------------------------

--
-- Структура таблицы `product_data`
--

CREATE TABLE `product_data` (
  `ID` int(11) NOT NULL,
  `Name` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `ProductType` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `ReleaseDate` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `Term` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `Firm` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `Country` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `Cost` varchar(300) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Дамп данных таблицы `product_data`
--

INSERT INTO `product_data` (`ID`, `Name`, `ProductType`, `ReleaseDate`, `Term`, `Firm`, `Country`, `Cost`) VALUES
(1, 'Clean Baby', 'Cream', '12.02.2018', '6 months', 'Horns and Hoofs', 'Ukraine', '32 UAH'),
(2, 'ChildPerfume', 'Perfume', '14.03.2018', '5 months', 'Nesstle', 'Switherland', '150 UAH');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `username` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(300) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`ID`, `username`, `password`) VALUES
(1, 'admin', 'd8578edf8458ce06fbc5bb76a58c5ca4'),
(2, 'Tolya', 'fdc7d852a4dbba2bbf060665d020b614'),
(5, 'as', 'c419b06b4c6579b50ff05adb3b8424f1'),
(6, 'name', 'c1a5298f939e87e8f962a5edfc206918');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `country_directory`
--
ALTER TABLE `country_directory`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `manufacturer`
--
ALTER TABLE `manufacturer`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `product_data`
--
ALTER TABLE `product_data`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `country_directory`
--
ALTER TABLE `country_directory`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT для таблицы `manufacturer`
--
ALTER TABLE `manufacturer`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `product_data`
--
ALTER TABLE `product_data`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
